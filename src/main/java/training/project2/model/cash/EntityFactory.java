package training.project2.model.cash;

import training.project2.model.entity.Container;
import training.project2.model.entity.Element;
import training.project2.model.entity.Type;

import java.util.List;


/**
 * Created by oleksij.onysymchuk@gmail on 04.12.2016.
 */
public interface EntityFactory {

    Element getElement(Type type, String content);

    Container getContainer(Type type, List<Element> elements);
}