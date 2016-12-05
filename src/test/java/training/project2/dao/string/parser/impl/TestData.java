package training.project2.dao.string.parser.impl;

/**
 * Created by oleksij.onysymchuk@gmail on 05.12.2016.
 */
public class TestData {
    public static final String SENTENCE = "word1 word2,word3,- word4     word5";
    public static final String PARAGRAPH = SENTENCE + "." + SENTENCE + "?" + SENTENCE + "!!!" + SENTENCE + ".";
    public static final String PARAGRAPHS = "\t" + PARAGRAPH + "\r\n\t" + PARAGRAPH + "\n\t" + PARAGRAPH + "\r\n";
    public static final String TEST_SENTENCE = " word1 word2, word3,- word4 word5";
    public static final String TEST_PARAGRAPH = TEST_SENTENCE + "." + TEST_SENTENCE + "?" + TEST_SENTENCE + "!!!" + TEST_SENTENCE + ".";
    public static final String TEST_PARAGRAPHS = "\t" + TEST_PARAGRAPH + "\n\t" + TEST_PARAGRAPH + "\n\t" + TEST_PARAGRAPH + "\n";
    public static final String TEST_CODE_1 = "\n" +
            "package training.project2.model.entity;\n" +
            "\n" +
            "import java.util.List;\n" +
            "\n" +
            "/**\n" +
            " * Created by oleksij.onysymchuk@gmail on 04.12.2016.\n" +
            " */\n" +
            "public interface Container extends Element {\n" +
            "\n" +
            "    List<Element> getElements();\n" +
            "\n" +
            "    List<Element> getAllTreeElements();\n" +
            "\n" +
            "    void setElements(List<Element> elements);\n" +
            "\n" +
            "    void addElement(Element el);\n" +
            "}\n";
    public static final String TEST_CODE_2 = "\n\t" +
            "package training.project2.model.entity;\n" +
            "\n" +
            "import java.util.List;\n" +
            "\n" +
            "/**\n" +
            " * Created by oleksij.onysymchuk@gmail on 04.12.2016.\n" +
            " */\n" +
            "public interface Container extends Element {\n" +
            "\n" +
            "    List<Element> getElements();\n" +
            "\n" +
            "    List<Element> getAllTreeElements();\n" +
            "\n" +
            "    void setElements(List<Element> elements);\n" +
            "\n" +
            "    void addElement(Element el);\n" +
            "}\n";

    public static final String TEST_TEXT = "\t" + TEST_PARAGRAPH +  TEST_CODE_1 + "\t" + TEST_PARAGRAPH +  TEST_CODE_2 +"\t"+ TEST_PARAGRAPH + TEST_CODE_1;
    public static final String TEXT = PARAGRAPH + "\n\t" + TEST_CODE_1 + PARAGRAPH + "\n" + TEST_CODE_2 + PARAGRAPH + TEST_CODE_1;
}
