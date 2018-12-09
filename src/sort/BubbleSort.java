package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] ints) {
        boolean flag = true;
        for(int i = 1; i < ints.length && flag; i++) {
            flag = false;
            for(int k = 0; k < ints.length - i;k++) {
                if(ints[k] > ints[k + 1]) {
                    ints[k] = ints[k] + ints[k + 1];
                    ints[k + 1] = ints[k] - ints[k + 1];
                    ints[k] = ints[k] - ints[k + 1];
                    flag = true;    //next pass still needed
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {3,4,7,5,1,6,9,34,8,10};
        int[] ints1 = {2,9,5,4,8,1,6};
        bubbleSort(ints);
        bubbleSort(ints1);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints1));
    }
}
