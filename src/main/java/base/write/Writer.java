package base.write;

import java.io.IOException;

/**
 * The writer interface represents the ability to write objects of specific type to a file
 * @param <T> - The type of data to be written
 */
public interface Writer<T> {
    /**
     * Add object to current batch
     * @param object - The object to be written
     * @throws IOException - if writing failed
     */
    public void write(T object) throws IOException;

    /**
     * Flush current batch into the destination
     * @throws IOException - if writing of batch failed
     */
    public void flush() throws IOException;
}
