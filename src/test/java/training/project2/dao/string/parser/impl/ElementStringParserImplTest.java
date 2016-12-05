package training.project2.dao.string.parser.impl;

import org.junit.Test;
import training.project2.model.cash.EntityFactory;
import training.project2.model.cash.impl.EntityFactoryImpl;
import training.project2.model.entity.Element;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static training.project2.dao.string.parser.impl.TestData.*;

/**
 * Created by oleksij.onysymchuk@gmail on 04.12.2016.
 */
public class ElementStringParserImplTest {
    private ElementStringParserImpl parser = new ElementStringParserImpl();
    private EntityFactory factory = EntityFactoryImpl.getInstance();


    @Test
    public void getTextFromStringFull() throws Exception {
        String result = parser.getTextFromString(TEXT).getContent();
        assertEquals(TEST_TEXT, result);
    }

    @Test
    public void getCode() throws Exception {
        String code =parser.getCode(TEST_CODE_1,0).code.getContent();
        assertEquals(TEST_CODE_1, code);
    }

    @Test
    public void getParagraphs() throws Exception {
        List<Element> parags = parser.getParagraphs(PARAGRAPHS);
        final String[] retrievedParagraphs = {""};
        parags.forEach(par -> {
            retrievedParagraphs[0] = retrievedParagraphs[0] + par.getContent();
        });
        assertEquals(TEST_PARAGRAPHS, retrievedParagraphs[0]);
    }

    @Test
    public void getSentences() throws Exception {
        List<Element> sentences = parser.getSentences(PARAGRAPH);
        final String[] retrievedSentences = {""};
        sentences.forEach(word -> {
            retrievedSentences[0] = retrievedSentences[0] + word.getContent();
        });
        assertEquals(TEST_PARAGRAPH, retrievedSentences[0]);
    }

    @Test
    public void getWords() throws Exception {
        List<Element> words = parser.getWords(SENTENCE);
        final String[] retrievedWords = {""};
        words.forEach(word -> {
            retrievedWords[0] = retrievedWords[0] + word.getContent();
        });
        assertEquals(TEST_SENTENCE, retrievedWords[0]);

    }

    @Test
    public void getSymbols() throws Exception {
        String word = "word";
        List<Element> symbols = parser.getSymbols(word);
        assertEquals("sizes must be equals", word.length(), symbols.size());
        for (int i = 0; i < word.length(); i++) {
            assertEquals("size of symbol must be 1", 1, symbols.get(i).getContent().length());
            assertEquals("chars must be equals", word.charAt(i), symbols.get(i).getContent().charAt(0));
        }
    }

}