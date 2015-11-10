package hw5.ch10.q1;

import java.util.Collection;

public interface MyQueue <E> {
    void enqueue(E e);
    void addAll(Collection<? extends E> c);
    E head();
    E dequeue();
    int size();
    boolean isEmpty();
}
