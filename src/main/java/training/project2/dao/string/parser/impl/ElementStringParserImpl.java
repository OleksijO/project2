package training.project2.dao.string.parser.impl;

import training.project2.dao.string.parser.ElementStringParser;
import training.project2.model.RegExp;
import training.project2.model.cash.EntityFactory;
import training.project2.model.cash.impl.EntityFactoryImpl;
import training.project2.model.entity.ContentType;
import training.project2.model.entity.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by oleksij.onysymchuk@gmail on 04.12.2016.
 */
public class ElementStringParserImpl implements ElementStringParser {
    Pattern codePattern = Pattern.compile(RegExp.REGEXP_CODE_START);
    EntityFactory factory = EntityFactoryImpl.getInstance();

    @Override
    public Element getTextFromString(String input) {
        List<Element> textContent = new ArrayList<>();
        int current = 0;
        while (current < input.length()) {
            Matcher codeMatcher = codePattern.matcher(input);
            if (codeMatcher.find(current)) {
                if (current == codeMatcher.start()) {
                    GetCodeResult codeResult = getCode(input, current+1);
                    textContent.add(codeResult.code);
                    current = codeResult.current;
                } else {
                    List<Element> paragraphs = getParagraphs(input.substring(current, codeMatcher.start()));
                    if (paragraphs != null && !paragraphs.isEmpty()) {
                        paragraphs.forEach(textContent::add);
                    }
                    current = codeMatcher.start();
                }
            } else {
                List<Element> paragraphs = getParagraphs(input.substring(current));
                if (paragraphs != null && !paragraphs.isEmpty()) {
                    paragraphs.forEach(textContent::add);
                }
                current = input.length();
            }
        }
        return factory.getContainer(ContentType.TEXT, textContent);
    }

    GetCodeResult getCode(String string, int current) {
        GetCodeResult codeResult = new GetCodeResult();
        List<Element> elements = new ArrayList<>();
        boolean blockOpened = false;
        int bracketCounter = 0;
        while (!(blockOpened && (bracketCounter == 0)) || (current >= string.length())) {
            char curr = string.charAt(current);
            if (curr == '{') {
                blockOpened = true;
                bracketCounter++;
            }
            if (curr == '}') {
                bracketCounter--;
            }
            elements.add(factory.getElement(ContentType.SYMBOL, curr));
            current++;
        }

        codeResult.code = factory.getContainer(ContentType.CODE, elements);
        codeResult.current = current;

        return codeResult;
    }

    static class GetCodeResult {
        int current;
        Element code;
    }

    List<Element> getParagraphs(String string) {
        String[] stringParagraphs = string.trim().split(RegExp.REGEXP_PARAGRAPH_SEPARATOR);
        List<Element> paragraphs = new ArrayList<>();
        for (String stringParagraph : stringParagraphs) {
            if (stringParagraph != null && !stringParagraph.isEmpty()) {
                List<Element> sentences = getSentences(stringParagraph);
                if (sentences != null && !sentences.isEmpty()) {
                    paragraphs.add(factory.getContainer(ContentType.PARAGRAPH, sentences));
                }
            }
        }
        return paragraphs;
    }

    List<Element> getSentences(String string) {
        String[] sents = string.replace("\\t|\\n|\\r", "").trim().split(RegExp.REGEXP_SENTENCE_SEPARATOR);
        int current = 0;
        Matcher separatorMatcher = Pattern.compile(RegExp.REGEXP_SENTENCE_SEPARATOR).matcher(string);
        List<Element> sentences = new ArrayList<>();
        for (String sent : sents) {
            if (sent != null && !sent.isEmpty()) {
                List<Element> words = getWords(sent.trim());
                if (words != null && !words.isEmpty()) {
                    sentences.add(factory.getContainer(ContentType.SENTENCE, words));
                }
            }
            if (separatorMatcher.find(current)) {
                char mark = string.charAt(separatorMatcher.start());
                current = separatorMatcher.end();
                sentences.add(factory.getElement(ContentType.END_SENTENCE_MARK, mark));
            }
        }
        return sentences;
    }

    List<Element> getWords(String string) {
        String[] stringWords = string.trim().split(RegExp.REGEXP_WORD_SEPARATOR);
        int current = 0;
        Matcher separatorMatcher = Pattern.compile(RegExp.REGEXP_WORD_SEPARATOR).matcher(string);
        List<Element> words = new ArrayList<>();
        for (String word : stringWords) {
            if (word != null && !word.trim().isEmpty()) {
                List<Element> symbols = getSymbols(word.trim());
                if (symbols != null && !symbols.isEmpty()) {
                    words.add(factory.getContainer(ContentType.WORD, symbols));
                }
            }
            if (separatorMatcher.find(current)) {
                char mark = string.charAt(separatorMatcher.start());
                current = separatorMatcher.end();
                if (mark != ' ') {
                    words.add(factory.getElement(ContentType.MARK, mark));
                }
            }

        }
        return words;


    }

    List<Element> getSymbols(String word) {
        List<Element> symbols = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            symbols.add(factory.getElement(ContentType.SYMBOL, word.charAt(i)));

        }
        return symbols;
    }


}