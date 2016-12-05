package training.project2.model.cash;

import training.project2.model.entity.Container;
import training.project2.model.entity.ContentType;
import training.project2.model.entity.Element;

import java.util.List;


/**
 * This interface describes Factory for Element hierarchy entities
 *
 * @author oleksij.onysymchuk@gmail
 */
public interface EntityFactory {

    /**
     * Retrieve element entity (type=Type.ELEMENT)
     *
     * @param type ContentType value of entity to be retrieved
     * @param c    value of element entity to be retrieved
     * @return element entity
     */
    Element getElement(ContentType type, char c);

    /**
     * Retrieve container entity (type=Type.CONTAINER)
     *
     * @param type     ContentType value of entity to be retrieved
     * @param elements list of elements of container entity to be retrieved
     * @return container entity
     */
    Container getContainer(ContentType type, List<Element> elements);

}
