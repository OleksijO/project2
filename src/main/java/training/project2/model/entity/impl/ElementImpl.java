package training.project2.model.entity.impl;

import training.project2.model.entity.Element;
import training.project2.model.entity.Type;

/**
 * Created by oleksij.onysymchuk@gmail on 04.12.2016.
 */
public class ElementImpl implements Element {
    private String content;
    private Type type;

    public ElementImpl(Type type, String content) {
        this.content = content;
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElementImpl element = (ElementImpl) o;

        if (content != null ? !content.equals(element.content) : element.content != null) return false;
        return type == element.type;

    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
