package datastructure.package_list;

import java.util.LinkedList;

public class MyQueue<E> {
    private LinkedList<E> list = new LinkedList<>();

    public void enqueue(E e) {
        list.addLast(e);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public int getSize() {
        return list.size();
    }

    @Override
    public String toString() {
        return "Queue: " + list.toString();
    }
}
