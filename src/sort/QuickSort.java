package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    public static void quickSort(int[] list, int first, int last) {
        int pivot;
        if (first < last) {
            pivot = partition(list, first, last);
            quickSort(list, first, pivot - 1);
            quickSort(list, pivot + 1, last);
        }
    }

    public static int partition(int[] list, int first, int last) {
        int pivotKey;
        pivotKey = list[first];

        while (first < last) {
            while (first < last && list[last] >= pivotKey)
                last--;
            swap(list, first, last);

            while (first < last && list[first] < pivotKey)
                first++;
            swap(list, first, last);
        }
        return first;
    }

    public static void swap(int[] list, int a, int b) {
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

    public static void main(String[] args) {
        int[] list = {5,2,9,3,8,14,0,1,6,7};
        int[] list1 = {1,2,3,4,5,6,7};
        int[] list2 = {7,6,5,4,3,2};
        int[] list3 = {2,3,2,5,6,1,-2,3,14,12};
        int[] list4 = {5,2,9,3,8,5,0,1,6,7};
        int[] list5 = {5,2,9,5,3,5,6,5,7};
        quickSort(list);
        quickSort(list1);
        quickSort(list2);
        quickSort(list3);
        quickSort(list4);
        quickSort(list5);
        System.out.println(Arrays.toString(list));
        System.out.println(Arrays.toString(list1));
        System.out.println(Arrays.toString(list2));
        System.out.println(Arrays.toString(list3));
        System.out.println(Arrays.toString(list4));
        System.out.println(Arrays.toString(list5));

//        int n;
//        Scanner input = new Scanner(System.in);
//        n = input.nextInt();
//        int[] list8 = new int[n];
//        for (int i = 0; i < n; i++)
//            list8[i] = input.nextInt();
//        System.out.println(Arrays.toString(list8));
    }
}
