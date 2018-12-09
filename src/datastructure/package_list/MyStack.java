package datastructure.package_list;

import java.util.ArrayList;

public class MyStack<E> {
    private ArrayList<E> list = new ArrayList<>();

    public int getSize() {
        return list.size();
    }

    public E peek() {
        return list.get(list.size() - 1);
    }

    public E pop() {
        E temp = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return temp;
    }

    public void push(E o) {
        list.add(o);
    }

    public boolean isEmpty() {
        return (list.size() == 0);
        //return list.isEmpty();
    }

    @Override
    public String toString() {
        return "Stack: " + list.toString();
    }
}
