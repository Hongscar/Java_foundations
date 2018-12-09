package sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] list) {
        if(list.length > 1) {
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            merge(firstHalf, secondHalf, list);
        }
    }

    public static void merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0, current2 = 0, current3 = 0;
        while (current1 < list1.length && current2 <list2.length) {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }

    public static void main(String[] args) {
        int[] ints = {3,4,7,5,1,6,9,34,8,10};
        int[] ints1 = {2,9,5,4,8,1,6};
        mergeSort(ints);
        mergeSort(ints1);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints1));
    }
}
