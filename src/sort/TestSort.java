package sort;

import java.util.Arrays;
import java.util.Scanner;

public class TestSort {
    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    public static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    public static int partition(int[] list, int first, int last) {

        int pivot = list[first];
        int low = first + 1;
        int high = last;

        while (high > low) {

            while (low <= high && list[low] <= pivot)
                low++;

            while (low <= high && list[high] > pivot)
                high--;

            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot)
            high--;     //if some values are equal with pivot,this can make pivot in the correct place
        //if miss this statement,pivot will not in the correct place
        //in this example,it will stay at the first place(means it doesn't swap at all)
        //another solution: the next statement add '='  if(pivot >= list[high])

        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else {
            return first;
        }
    }

    public static void main(String[] args) {
        int k;
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
//        Scanner input = new Scanner(System.in);
//        int n;
//        int temp;
//        n = input.nextInt();
//        int[] list = new int[n];
//        for(int i = 0; i < n; i++) {
//            list[i] = input.nextInt();
//        }
//        quickSort(list);
//        for (int i = 0; i < list.length - 1; i++)
//            System.out.print(list[i] + " ");
//        System.out.print(list[n - 1]);

    }
}