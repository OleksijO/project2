package training.project2.model.process;

import training.project2.model.entity.Element;
import training.project2.model.process.strategy.ProcessStrategy;

/**
 * This interface describes element processor for processing elements with specified strategy
 *
 * @author oleksij.onysymchuk@gmail
 */
public interface ElementProcessor {

    /**
     * @param elementToProcess element entity has to be processed
     * @return processed element entity
     */
    Element process(Element elementToProcess);

    /**
     * @param strategy strategy implementation for processing element entity
     */
    void setStrategy(ProcessStrategy strategy);

}
