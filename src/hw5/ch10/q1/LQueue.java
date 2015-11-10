package hw5.ch10.q1;
import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LQueue <E> implements MyQueue <E> {

    public LQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(E e) {
        queue.add(e);
    }

    public void addAll(Collection<? extends E> c) {
        queue.addAll(c);
    }

    public E head() {
        try {
            return queue.element();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("queue is empty");
        }
    }

    public E dequeue() {
        try {
            return queue.removeFirst();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("queue is empty");
        }
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    private LinkedList <E> queue;
}
