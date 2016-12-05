package training.project2.dao.file.impl;

import org.apache.commons.io.FileUtils;
import training.project2.dao.ElementDao;
import training.project2.dao.file.impl.string.parser.ElementStringParser;
import training.project2.dao.file.impl.string.parser.impl.ElementStringParserImpl;
import training.project2.model.entity.Element;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * This is implementation of elemnt entity DAO for file storage.
 *
 * @author oleksij.onysymchuk@gmail
 */
public class ElementDaoFileImpl implements ElementDao {
    public static final String SPECIFIED_INPUT_SOURCE_FILE_DOES_NOT_EXIST_FORMAT = "Specified input source file '%s' does not exist!";
    public static final String FILE_ENCODING = "UTF-8";
    public static final String ERROR_WHILE_READING_FILE = "Error while reading file ";
    public static final String ERROR_WHILE_WRITING_FILE = "Error while writing file ";

    private File file;

    ElementStringParser stringParser = new ElementStringParserImpl();

    public ElementDaoFileImpl(String fileName) {
        Objects.requireNonNull(fileName);
        this.file = new File(fileName);
    }

    @Override
    public Element getElement() {
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format(SPECIFIED_INPUT_SOURCE_FILE_DOES_NOT_EXIST_FORMAT, file.getAbsolutePath()));
        }
        try {

            return stringParser.getTextFromString(FileUtils.readFileToString(file, FILE_ENCODING));

        } catch (IOException e) {
            throw new RuntimeException(ERROR_WHILE_READING_FILE + file.getAbsolutePath());
        }
    }

    @Override
    public void createElement(Element element) {
        Objects.requireNonNull(element);
        try {
            FileUtils.writeStringToFile(file, element.getContent(), FILE_ENCODING);
        } catch (IOException e) {
            throw new RuntimeException(ERROR_WHILE_WRITING_FILE + file.getAbsolutePath());
        }

    }

    @Override
    public void updateElement(Element element) {
        createElement(element);
    }

    @Override
    public void removeElement() {
        FileUtils.deleteQuietly(file);
    }
}
