package training.project2.dao.file.impl.string.parser.impl;

import training.project2.dao.file.impl.string.parser.ElementStringParser;
import training.project2.dao.file.impl.string.parser.RegExp;
import training.project2.model.cash.EntityFactory;
import training.project2.model.cash.impl.EntityFactoryImpl;
import training.project2.model.entity.ContentType;
import training.project2.model.entity.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is imp[lementation of string to element entity parser.
 * It uses entity factory to decrease constant memory usage.
 *
 * @author oleksij.onysymchuk@gmail
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
                    GetCodeResult codeResult = getCode(input, current + 1);
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

    /**
     * @param string  String to be parsed
     * @param current Parsing start position in specified string
     * @return DTO with parsed code entity and position of end of code in specified string
     */
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

    /**
     * DTO for getCode method
     */
    static class GetCodeResult {
        /**
         * position of end of code in specified string arg of method
         */
        int current;
        /**
         * parsed code entity
         */
        Element code;
    }

    /**
     * @param string String value to parsed to paragraph entity list
     * @return paragraph entity list
     */
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

    /**
     * @param string String value to parsed to sentence entity list
     * @return sentence entity list
     */
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

    /**
     * @param string String value to parsed to words entity list
     * @return words entity list
     */
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

    /**
     * @param word String value to parsed to symbols entity list
     * @return symbols entity list
     */
    List<Element> getSymbols(String word) {
        List<Element> symbols = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            symbols.add(factory.getElement(ContentType.SYMBOL, word.charAt(i)));

        }
        return symbols;
    }


}