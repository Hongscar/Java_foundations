package datastructure.package_list;


public interface MyList<E> extends Iterable<E> {
    public void add(E e);

    public void add(int index, E e);

    public void clear();

    public boolean contains(E e);

    public E get(int index);

    public int indexOf(E e);

    public boolean isEmpty();

    public int lastIndexOf(E e);

    public boolean remove(E e);

    public E remove(int index);

    /** replace the element at the specified position with the specified element
    /*  and return the old element  */
    public Object set(int index, E e);

    public int size();

}

