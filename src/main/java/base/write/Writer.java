package base.write;

/**
 * The writer interface represents the ability to write objects of specific type to a file
 * @param <T> - The type of data to be written
 */
public interface Writer<T> {
    /**
     * Add object to current batch
     * @param object - The object to be written
     */
    public void write(T object);

    /**
     * Flush current batch into the destination
     */
    public void flush();
}
