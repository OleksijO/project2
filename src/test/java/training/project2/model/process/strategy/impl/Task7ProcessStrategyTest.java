package training.project2.model.process.strategy.impl;

import org.junit.Assert;
import org.junit.Test;
import training.project2.dao.file.impl.string.parser.ElementStringParser;
import training.project2.dao.file.impl.string.parser.impl.ElementStringParserImpl;
import training.project2.model.entity.Element;

/**
 * Created by oleksij.onysymchuk@gmail on 05.12.2016.
 */
public class Task7ProcessStrategyTest {
    private Element testElement;
    private ElementStringParser parser = new ElementStringParserImpl();

    @Test
    public void testPerformProcess1() throws Exception {
        testElement = parser.getTextFromString(TaskTestData.TEST_1);
        Element processedElement = new Task7ProcessStrategy().performProcess(testElement);
        Assert.assertEquals(TaskTestData.TEST_1_CONTROL, processedElement.getContent());
    }

    @Test
    public void testPerformProcess2() throws Exception {
        testElement = parser.getTextFromString(TaskTestData.TEST_2);
        Element processedElement = new Task7ProcessStrategy().performProcess(testElement);
        Assert.assertEquals(TaskTestData.TEST_2_CONTROL, processedElement.getContent());
    }

}