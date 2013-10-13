package name.tupitsky.filequeue;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class LinkedListFileQueue<T extends Serializable> implements FileQueue<T>  {
    private final List<T> list = new LinkedList<T>();

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(T data) throws IOException {
        list.add(data);
    }

    @Override
    public T dequeue() throws IOException {
        return list.remove(0);
    }

    @Override
    public void purge() throws IOException {
        list.clear();
    }

    @Override
    public T peek() throws IOException {
        return list.get(0);
    }

    @Override
    public T[] getAll() throws IOException {
        return (T[]) list.toArray();
    }
}
