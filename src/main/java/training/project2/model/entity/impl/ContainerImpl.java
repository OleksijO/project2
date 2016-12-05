package training.project2.model.entity.impl;

import training.project2.model.entity.Container;
import training.project2.model.entity.ContentType;
import training.project2.model.entity.Element;
import training.project2.model.entity.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleksij.onysymchuk@gmail on 04.12.2016.
 */
public class ContainerImpl implements Container {
    protected ContentType contentType;
    protected List<Element> elements;

    public ContainerImpl(ContentType type, List<Element> elements) {
        this.contentType = type;
        this.elements = elements;
    }

    @Override
    public ContentType getContentType() {
        return contentType;
    }

    @Override
    public Type getType() {
        return Type.CONTAINER;
    }

    @Override
    public String getContent() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(contentType.separatorBefore);
        elements.forEach(el ->
                stringBuilder
                        .append(el.getContent())
        );
        stringBuilder.append(contentType.separatorAfter);
        return stringBuilder.toString();
    }

    @Override
    public List<Element> getElements() {
        return elements;
    }

    @Override
    public List<Element> getAllTreeElements() {
        List<Element> allElements = new ArrayList<>(elements);
        elements.forEach(element -> {
            if (element.getType()==Type.CONTAINER){
                allElements.addAll(((Container)element).getAllTreeElements());
            } else {
                allElements.add(element);
            }
        });
        return allElements;
    }

    @Override
    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public void addElement(Element el) {
        elements.add(el);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContainerImpl container = (ContainerImpl) o;

        if (contentType != container.contentType) return false;
        return elements != null ? elements.equals(container.elements) : container.elements == null;

    }

    @Override
    public int hashCode() {
        int result = contentType != null ? contentType.hashCode() : 0;
        result = 31 * result + (elements != null ? elements.hashCode() : 0);
        return result;
    }
}
