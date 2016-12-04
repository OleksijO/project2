package training.project2.model.cash.impl;

import training.project2.model.cash.EntityFactory;
import training.project2.model.entity.Container;
import training.project2.model.entity.Element;
import training.project2.model.entity.Type;
import training.project2.model.entity.impl.ContainerImpl;
import training.project2.model.entity.impl.ElementImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by oleksij.onysymchuk@gmail on 04.12.2016.
 */
public class EntityFactoryImpl implements EntityFactory {
    private Map<Type, Map<String, Element>> elementCash = new HashMap<>();
    private Map<Type, Map<List<Element>, Container>> componentCash = new HashMap<>();

    @Override
    public Element getElement(Type type, String content) {
        Map<String, Element> typeCash = elementCash.get(type);
        if (typeCash == null) {
            typeCash = new HashMap<>();
        }
        Element element = typeCash.get(content);
        if (element == null) {
            element = new ElementImpl(type, content);
        }
        return element;
    }

    @Override
    public Container getContainer(Type type, List<Element> elements) {
        Map<List<Element>, Container> typeCash = componentCash.get(type);
        if (typeCash == null) {
            typeCash = new HashMap<>();
        }
        Container element = typeCash.get(elements);
        if (element == null) {
            element = new ContainerImpl(type, elements);
        }
        return element;
    }

}
