package training.project2.model.process;

import training.project2.model.entity.Element;
import training.project2.model.process.strategy.ProcessStrategy;

/**
 * Created by oleksij.onysymchuk@gmail on 05.12.2016.
 */
public interface ElementProcessor {

    Element process(Element elementToProcess);

    void setStrategy(ProcessStrategy strategy);

}
