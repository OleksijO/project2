package training.project2.model.cash.impl;

import training.project2.model.cash.EntityFactory;
import training.project2.model.entity.Container;
import training.project2.model.entity.Element;
import training.project2.model.entity.ContentType;
import training.project2.model.entity.impl.ContainerImpl;
import training.project2.model.entity.impl.ElementImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by oleksij.onysymchuk@gmail on 04.12.2016.
 */
public class EntityFactoryImpl implements EntityFactory {
    private static final EntityFactoryImpl instance = new EntityFactoryImpl();
    private Map<ContentType, Map<Character, Element>> elementCash = new HashMap<>();
    private Map<ContentType, Map<List<Element>, Container>> containerCash = new HashMap<>();

    private EntityFactoryImpl() {
    }

    public static EntityFactory getInstance(){
        return instance;
    }

    @Override
    public Element getElement(ContentType type, char c) {
        Map<Character, Element> typeCash = elementCash.get(type);
        if (typeCash == null) {
            typeCash = new HashMap<>();
            elementCash.put(type, typeCash);
        }
        Element element = typeCash.get(c);
        if (element == null) {
            element = new ElementImpl(type, c);
            typeCash.put(c, element);

        }
        return element;
    }

    @Override
    public Container getContainer(ContentType type, List<Element> elements) {
        Map<List<Element>, Container> typeCash = containerCash.get(type);
        if (typeCash == null) {
            typeCash = new HashMap<>();
            containerCash.put(type, typeCash);
        }
        Container container = typeCash.get(elements);
        if (container == null) {
            container = new ContainerImpl(type, elements);
            typeCash.put(elements, container);
        }
        return container;
    }

}
