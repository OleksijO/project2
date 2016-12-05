package training.project2.dao.file.impl;

import org.junit.Before;
import org.junit.Test;
import training.project2.dao.ElementDao;
import training.project2.dao.file.impl.string.parser.impl.ElementStringParserImpl;
import training.project2.dao.file.impl.string.parser.impl.TestData;
import training.project2.model.entity.Container;
import training.project2.model.entity.Element;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by oleksij.onysymchuk@gmail on 05.12.2016.
 */
public class ElementFileDaoImplTest {
    private String fileName = "testfile.tmp";
    private ElementDao elementDao = new ElementDaoFileImpl(fileName);
    private Element gaugeElement;

    @Before
    public void init() {
        gaugeElement = new ElementStringParserImpl().getTextFromString(TestData.TEXT);
        elementDao.createElement(gaugeElement);
    }

    @Test
    public void getElement() throws Exception {
        assertEquals(gaugeElement, elementDao.getElement());
    }

    @Test
    public void createElement() throws Exception {
        elementDao.createElement(gaugeElement);
        assertEquals(gaugeElement, elementDao.getElement());
    }

    @Test
    public void updateElement() throws Exception {
        ((Container) gaugeElement).getElements().remove(0);
        elementDao.updateElement(gaugeElement);
        assertEquals(gaugeElement, elementDao.getElement());
    }

    @Test
    public void removeElement() throws Exception {
        elementDao.removeElement();
        assertFalse(new File(fileName).exists());
    }

}