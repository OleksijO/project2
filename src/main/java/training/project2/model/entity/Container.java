package training.project2.model.entity;

import java.util.List;

/**
 * Created by oleksij.onysymchuk@gmail on 04.12.2016.
 */
public interface Container extends Element {

    List<Element> getElements();

    List<Element> getAllTreeElements();

    void setElements(List<Element> elements);

    void addElement(Element el);
}
