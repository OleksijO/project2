package training.project2.model.entity;

/**
 * This interface describes element entity behaviour
 *
 * @author oleksij.onysymchuk@gmail
 */
public interface Element {

    /**
     * @return content type of entity
     */
    ContentType getContentType();

    /**
     * @return type of element in Element hierarchy (similar to getClass)
     */
    Type getType();

    /**
     * @return String representation of content
     */
    String getContent();

}
