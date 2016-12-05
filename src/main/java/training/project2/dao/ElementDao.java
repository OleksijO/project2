package training.project2.dao;

import training.project2.model.entity.Element;

/**
 * This interface describes parser DAO to some storage of element
 *
 * @author oleksij.onysymchuk@gmail
 */
public interface ElementDao {

    /**
     * Retrieves element entity form storage
     *
     * @return entity element
     */
    Element getElement();

    /**
     * Creates element in storage
     *
     * @param element entity to be created
     */
    void createElement(Element element);

    /**
     * Updates entity in storage
     *
     * @param element entity to be updated
     */
    void updateElement(Element element);

    /**
     * Removes entity from storage
     */
    void removeElement();

}
