package training.project2.model.entity.impl;

import training.project2.model.entity.Container;
import training.project2.model.entity.Element;
import training.project2.model.entity.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleksij.onysymchuk@gmail on 04.12.2016.
 */
public class ContainerImpl implements Container {
    protected Type type;
    protected List<Element> elements;

    public ContainerImpl(Type type, List<Element> elements) {
        this.type = type;
        this.elements = elements;
    }

    @Override
    public Type getType() {
       return type;
    }

    @Override
    public String getContent() {
        StringBuilder stringBuilder = new StringBuilder();
        elements.forEach(el ->
                stringBuilder
                        .append(type.separatorBefore)
                        .append(el.getContent())
                        .append(type.separatorAfter)
        );
        return stringBuilder.toString();
    }

    @Override
    public List<Element> getElements(){
        return elements;
    }

    @Override
    public List<Element> getAllTreeElements(){
        List<Element> allElements = new ArrayList<>(elements);
        elements.forEach(element -> allElements.add(element));
        return allElements;
    }

    @Override
    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public void addElement(Element el){
        elements.add(el);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContainerImpl container = (ContainerImpl) o;

        if (type != container.type) return false;
        return elements != null ? elements.equals(container.elements) : container.elements == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (elements != null ? elements.hashCode() : 0);
        return result;
    }
}
