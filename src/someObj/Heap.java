package someObj;


import java.util.ArrayList;

public class Heap<E extends Comparable<E>>{
    private ArrayList<E> list = new ArrayList<>();

    public Heap() {

    }

    public Heap(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    public void add(E newObject) {
        list.add(newObject);
        int currentIndex = list.size() - 1;
        int parentIndex = (currentIndex - 1) / 2;
        //if (parentIndex < 0) return;

        while (currentIndex > 0) {
            if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);

                currentIndex = parentIndex;
                parentIndex = (currentIndex - 1) / 2;
            }
            else
                break;
        }
    }

    public E remove() { //delete the root element
        if (list.size() == 0) return null;

        int currentIndex = list.size() - 1;
        E root = list.get(0);

        list.set(0, list.get(currentIndex));
        list.remove(list.size() - 1);

        currentIndex = 0;
        int leftChild = 2 * currentIndex + 1;
        int rightChild = 2 * currentIndex + 2;

        while (leftChild < list.size()) {   //index begin at 0,size begin at 1

            E left_element = list.get(leftChild);
            E temp = left_element;
            int tempIndex = leftChild;
            E right_element;
            if (rightChild < list.size()) {
                right_element = list.get(rightChild);
                if (left_element.compareTo(right_element) < 0) {
                    temp = right_element;
                    tempIndex = rightChild;
                }
            }

            if (list.get(currentIndex).compareTo(temp) < 0) {
                //E temp1 = list.get(currentIndex);
               // E temp = list.get(tempIndex);   //max child
                list.set(tempIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = tempIndex;
                leftChild = 2 * currentIndex + 1;
                rightChild = 2 * currentIndex + 2;
            }
            else {
                break;
            }
        }

        return root;
    }

    public int getSize() {
        return list.size();
    }

    public static void main(String[] args) {

        Integer[] integers = {62,42,59,32,39,44,13,22,29,14,33,30,17,9};
        Heap<Integer> heap = new Heap<>(integers);


        System.out.println(heap.list);

        heap.remove();
        System.out.println(heap.list);

        heap.remove();
        System.out.println(heap.list);
    }



}
