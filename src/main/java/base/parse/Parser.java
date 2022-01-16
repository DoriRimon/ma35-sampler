package base.parse;

import java.util.List;

/**
 * The Parser interface represents objects that parse data of specific type from a file
 * @param <T> - The type of data to be parsed
 */
public interface Parser<T> {
    public List<T> getRecords();
}
