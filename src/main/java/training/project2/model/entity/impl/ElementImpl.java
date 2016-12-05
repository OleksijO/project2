package training.project2.model.entity.impl;

import training.project2.model.entity.Element;
import training.project2.model.entity.ContentType;
import training.project2.model.entity.Type;

/**
 * Created by oleksij.onysymchuk@gmail on 04.12.2016.
 */
public class ElementImpl implements Element {
    private char content;
    private ContentType type;

    public ElementImpl(ContentType type, char content) {
        this.content = content;
        this.type = type;
    }

    @Override
    public ContentType getContentType() {
        return type;
    }

    @Override
    public Type getType() {
        return Type.ELEMENT;
    }

    @Override
    public String getContent() {
        return Character.toString(content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElementImpl element = (ElementImpl) o;

        if (content != element.content) return false;
        return type == element.type;

    }

    @Override
    public int hashCode() {
        int result = (int) content;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
