package training.project2.model;

/**
 * Created by oleksij.onysymchuk@gmail on 04.12.2016.
 */
public interface RegExp {
    String REGEXP_PARAGRAPH = "\\t[^\\t]+";
    String REGEXP_SENTENCE = " [^.^!^?]+";
    String REGEXP_WORD = "[^,^;^:^\\-^\\s]+";
    String REGEXP_CODE_START = "\\n(\\t)?(package|import|public|protected|class|interface|enum|abstract|private)";

    String REGEXP_PARAGRAPH_SEPARATOR = "(\\n|\\r\\n)\\t";
    String REGEXP_SENTENCE_SEPARATOR = "(\\.|\\!|\\?)";
    String REGEXP_WORD_SEPARATOR = "( |,|;|:|\\-)";



}
