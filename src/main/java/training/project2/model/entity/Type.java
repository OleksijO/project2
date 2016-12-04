package training.project2.model.entity;

/**
 * Created by oleksij.onysymchuk@gmail on 04.12.2016.
 */
public enum Type {
    TEXT("",""),
    PARAGRAPH("","\n"),
    SENTENCE(""," "),
    WORD(""," "),
    CODE("","\n"),
    MARK(""," ");

    public String separatorAfter;
    public String separatorBefore;

    Type(String separatorBefore, String separatorAfter) {
        this.separatorBefore = separatorBefore;
        this.separatorAfter = separatorAfter;
    }
}
