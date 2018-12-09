package sort;

import someObj.Heap;

import java.math.BigInteger;
import java.util.Calendar;

public class HeapSort {
    public static <E extends Comparable<E>> void heapSort(E[] lists) {
        Heap<E> heap = new Heap<>(lists);

        for (int i = 0; i < lists.length; i++)
            lists[i] = heap.remove();
    }

    public static void main(String[] args111) {
        Integer[] list = {-44,-5,-3,3,3,1,-4,0,1,2,4,5,53};
        heapSort(list);
        for (Integer integer : list)
            System.out.print(integer + " ");

        //Heap<xx> heap = new Heap<>();     xx can not be Object or Number,cause they don't implement comparable
    }
}
