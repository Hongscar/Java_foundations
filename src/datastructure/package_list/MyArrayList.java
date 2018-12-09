package datastructure.package_list;

import java.util.Iterator;
import java.util.function.Consumer;

public class MyArrayList<E> extends MyAbstractList<E> {
    public static final int INITIAL_CAPACITY = 16;
    private E[] data = (E[]) new Object[INITIAL_CAPACITY];//avoid the limit of the generic type

    public MyArrayList() {
    }

    public MyArrayList(E[] objects) {
    //    super(objects);
    // when invoke super class's constructor,the E[] data has not been initialized yet,then nullpointerexception
    //    data = objects;   data and objects refet to the same array,it's a security hole
        //you may change Arraylist by directing changing the array elements through objects!
    //    size = objects.length;
        for (E element : objects)
                add(element);
    }

    public void ensureCapacity() {
        if (size >= data.length) {
            E[] newData = (E[])(new Object[size * 2 + 1]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    @Override
    public void add(int index, E e) {
        ensureCapacity();

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;

        size++;
    }

    @Override
    public void clear() {
        data = (E[])new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean contains(E e) {
        for (E element : data)
            if (e.equals(element)) return true;
        return false;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index " + index + " out of bounds" );
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(data[i])) return i;
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= 0; i--)
            if (e.equals(data[i])) return i;
        return -1;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        E e = data[index];

        for (int j = index; j < size - 1; j++)
            data[j] = data[j + 1];

        data[size - 1] = null;  //the deleted element is now null

        size--;

        return e;
    }

    @Override
    public Object set(int index, E e) {
        checkIndex(index);
        E old = data[index];
        data[index] = e;
        return old;
    }

    @Override   //each collection class has implemented the toString method!
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) result.append(", ");
        }

        result.append("]");

        return result.toString();
    }

    public void trimToSize() {
        if (size != data.length) {
            E[] newData = (E[])(new Object[size]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        private int current = 0;    //current index

        @Override
        public boolean hasNext() {
            return (current < size);
        }

        @Override
        public E next() {
            return data[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(current);
        }

    }
}
