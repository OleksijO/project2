package training.project2.dao;

import training.project2.model.entity.Element;

/**
 * Created by oleksij.onysymchuk@gmail on 04.12.2016.
 */
public interface ElementDao {

    Element getElement();

    void createElement(Element element);

    void updateElement(Element element);

    void removeElement();

}
