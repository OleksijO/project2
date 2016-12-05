package training.project2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import training.project2.dao.ElementDao;
import training.project2.dao.file.impl.ElementDaoFileImpl;
import training.project2.dao.file.impl.string.parser.impl.ElementStringParserImpl;
import training.project2.model.entity.Element;
import training.project2.model.process.ElementProcessor;
import training.project2.model.process.impl.ElementProcessorImpl;
import training.project2.model.process.strategy.impl.Task7ProcessStrategy;
import training.project2.model.process.strategy.impl.TaskTestData;

/**
 * Created by oleksij.onysymchuk@gmail on 05.12.2016.
 */
public class ElementProcessorIntegrationTestTask7 {
    private Element testElement;
    private Element gaugeElement;
    private String fileName = "integration_test_task_7.tmp";

    @Before
    public void init() {
        testElement = new ElementStringParserImpl().getTextFromString(TaskTestData.TEST_2);
        gaugeElement = new ElementStringParserImpl().getTextFromString(TaskTestData.TEST_2_CONTROL);
        new ElementDaoFileImpl(fileName).createElement(testElement);
    }

    @Test
    public void integrationTest() {
        ElementDao dao = new ElementDaoFileImpl(fileName);
        Element text = dao.getElement();
        ElementProcessor processor = new ElementProcessorImpl(new Task7ProcessStrategy());
        text = processor.process(text);
        dao.updateElement(text);

        Assert.assertEquals(gaugeElement, dao.getElement());
    }
}
