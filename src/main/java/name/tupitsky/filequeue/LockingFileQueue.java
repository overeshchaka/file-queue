package name.tupitsky.filequeue;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockingFileQueue<T extends Serializable> implements FileQueue<T> {

    private final Lock lock = new ReentrantLock();

    private final FileQueue queue;

    public LockingFileQueue(FileQueue queue) {
        this.queue = queue;
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        boolean result = queue.isEmpty();
        lock.unlock();
        return result;
    }

    @Override
    public void enqueue(T data) throws IOException {
        lock.lock();
        queue.enqueue(data);
        lock.unlock();
    }

    @Override
    public T dequeue() throws IOException {
        lock.lock();
        T result = (T) queue.dequeue();
        lock.unlock();
        return result;
    }

    @Override
    public void purge() throws IOException {
        lock.lock();
        queue.purge();
        lock.unlock();
    }

    @Override
    public T peek() throws IOException {
        lock.lock();
        T result = (T) queue.peek();
        lock.unlock();
        return result;
    }

    @Override
    public T[] getAll() throws IOException {
        lock.lock();
        T result[] = (T[]) queue.getAll();
        lock.unlock();
        return result;
    }
}
