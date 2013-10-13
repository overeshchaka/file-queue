package name.tupitsky.filequeue;

import java.io.IOException;
import java.io.Serializable;

public interface FileQueue<T extends Serializable> {
    /**
     * Determines whether a queue is empty
     *
     * @return ture if empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Adds an item at the back of a queue
     *
     * @param data to be enqueued data
     * @throws IOException exception is thrown in case any IO error during enqueue operation.
     */
    public void enqueue(T data) throws IOException;

    /**
     * Retrieves and removes the front of a queue
     *
     * @return data at the front of a queue
     * @throws IOException exception is thrown in case any IO error during dequeue operation.
     */
    public T dequeue() throws IOException;

    /**
     * Removes all items of a queue, this will empty the queue and delete all back data files.
     *
     * @throws IOException exception is thrown in case any IO error during dequeue operation.
     */
    public void purge() throws IOException;

    /**
     * Retrieves the item at the front of a queue without deletion
     *
     * @return data at the front of a queue
     * @throws IOException exception is thrown in case any IO error during peek operation.
     */
    public T peek() throws IOException;

    /**
     * Gets all data items without deletion
     *
     * @return all data
     * @throws IOException exception is thrown in case any IO error during peek operation.
     */
    public T[] getAll() throws IOException;
}
