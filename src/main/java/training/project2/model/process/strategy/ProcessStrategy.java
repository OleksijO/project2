package training.project2.model.process.strategy;

import training.project2.model.entity.Element;

/**
 * This interface describes element processor strategy behaviour
 *
 * @author oleksij.onysymchuk@gmail
 */
public interface ProcessStrategy {

    /**
     * @param element element has to be processed
     * @return processed element depending on implemented strategy
     */
    Element performProcess(Element element);

}
