package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];

            for (int k = i - 1; k >= 0; k--) {
                if (list[k] > currentElement) {
                    list[k + 1] = list[k];
                    list[k] = currentElement;
                } else
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {3,4,7,5,1,6,9,34,8,10};
        int[] ints1 = {2,9,5,4,8,1,6};
        insertionSort(ints);
        insertionSort(ints1);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints1));
    }
}
