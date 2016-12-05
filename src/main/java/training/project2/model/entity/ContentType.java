package training.project2.model.entity;

/**
 * This enum determines all the types of content in Element hierarchy
 *
 * @author oleksij.onysymchuk@gmail
 */
public enum ContentType {
    TEXT("",""),                    // list of PARAGRAPHs and CODEs
    PARAGRAPH("\t","\n"),           // list of SENTENCEs
    SENTENCE("",""),                // list of WORDs, MARKs and END_SENTENCE_MARK at the end of list
    WORD(" ",""),                   // list of SYMBOLs
    CODE("","\n"),                  // everything starts with package, import, public, protected, class
    SYMBOL("",""),                  // everything but new row, tab, mark, end sentence mark.
    MARK(""," "),                   // , ; : -
    END_SENTENCE_MARK(""," ");      // . ! ?

    /**
     * Symbol, which is used in string representation (by call getContent() method)
     * and will be placed once before  string representation of content of element
     */
    public String separatorAfter;
    /**
     * Symbol, which is used in string representation (by call getContent() method)
     * and will be placed once after string representation of content of element
     */
    public String separatorBefore;

    ContentType(String separatorBefore, String separatorAfter) {
        this.separatorBefore = separatorBefore;
        this.separatorAfter = separatorAfter;
    }
}
