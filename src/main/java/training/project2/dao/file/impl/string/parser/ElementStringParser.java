package training.project2.dao.file.impl.string.parser;

import training.project2.model.entity.Element;

/**
 * This interface describes parser from string to element entity behaviour
 *
 * @author oleksij.onysymchuk@gmail
 */
public interface ElementStringParser {

    /**
     * @param input string value to be parsed
     * @return Constructed element entity
     */
    Element getTextFromString(String input);

}
