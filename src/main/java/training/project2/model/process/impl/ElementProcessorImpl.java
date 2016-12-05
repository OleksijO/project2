package training.project2.model.process.impl;

import training.project2.model.entity.Element;
import training.project2.model.process.ElementProcessor;
import training.project2.model.process.strategy.ProcessStrategy;

/**
 * Created by oleksij.onysymchuk@gmail on 05.12.2016.
 */
public class ElementProcessorImpl implements ElementProcessor {
    private ProcessStrategy strategy;

    public ElementProcessorImpl(ProcessStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Element process(Element elementToProcess) {
        return strategy.performProcess(elementToProcess);
    }

    @Override
    public void setStrategy(ProcessStrategy strategy) {
        this.strategy = strategy;
    }
}
