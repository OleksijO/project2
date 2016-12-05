package training.project2.model.entity;

import java.util.List;

/**
 * This interface describes container entity behaviour
 *
 * @author oleksij.onysymchuk@gmail
 */
public interface Container extends Element {

    /**
     * @return only list of direct child elements in container
     */
    List<Element> getElements();

    /**
     * @return list of all hierarchy of child elements:
     * in order: 1st child, children of 1st child with their children..., 2nd child, children of 2nc child with etc..
     */
    List<Element> getAllTreeElements();

}
