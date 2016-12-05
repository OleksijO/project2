package training.project2.model.entity;

/**
 * Created by oleksij.onysymchuk@gmail on 04.12.2016.
 */
public enum ContentType {
    TEXT("",""),
    PARAGRAPH("\t","\n"),
    SENTENCE("",""),
    WORD(" ",""),
    CODE("","\n"),                    // everything starts with package, import, public, protected, class
    SYMBOL("",""),                  //everything but new row, tab, mark, end sentence mark.
    MARK(""," "),                   // , ; : -
    END_SENTENCE_MARK(""," ");      // . ! ?

    public String separatorAfter;
    public String separatorBefore;

    ContentType(String separatorBefore, String separatorAfter) {
        this.separatorBefore = separatorBefore;
        this.separatorAfter = separatorAfter;
    }
}
