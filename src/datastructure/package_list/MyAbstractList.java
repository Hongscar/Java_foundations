package datastructure.package_list;

public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size = 0;

    protected MyAbstractList() {

    }

    protected MyAbstractList(E[] objects) {
        for (E element : objects)
            add(element);
    }

    @Override
    public void add(E e) {
        add(size, e);   //each class can invoke the method in the interface
                        //the object that extends this abstract class(concrete class)will implement this method
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean remove(E e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        }
        else
            return false;
    }
}
