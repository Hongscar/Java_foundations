package testMultithread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelMax {
    public static void main(String[] args) {
        final int N = 100000000;
        int[] list = new int[N];
        for (int i = 0; i < list.length; i++)
            list[i] = i;

        long startTime = System.currentTimeMillis();
        System.out.println("\nThe maximal number is " + max(list));
        long endTime = System.currentTimeMillis();
        System.out.println("The number of processors is " + Runtime.getRuntime().availableProcessors());
        System.out.println("Time is " + (endTime - startTime) + " milliseconds");

        long startTime1 = System.currentTimeMillis();
        System.out.println("\nSequential max to find the number is " + sequentialMax(list));
        long endTime1 = System.currentTimeMillis();
        System.out.println("Time cost :" + (endTime1 - startTime1) + " millseconds");
    }

    public static int sequentialMax(int[] list) {
        int max = list[0];
        for (int i = 0; i < list.length; i++)
            if (max < list[i])
                max = list[i];
        return max;
    }

    public static int max(int[] list) {
        RecursiveTask<Integer> task = new MaxTask(list, 0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }

    private static class MaxTask extends RecursiveTask<Integer> {
        private final static int THRESHOLD = 10000;
        private int[] list;
        private int low;
        private int high;

        public MaxTask(int[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;
        }

        @Override
        public Integer compute() {
            if (high - low < THRESHOLD) {
                int max = list[0];
                for (int i = low; i < high; i++)
                    if (list[i] > max)
                        max = list[i];
                return new Integer(max);
            }
            else {
                int mid = (low + high) / 2;
                RecursiveTask<Integer> left = new MaxTask(list, low, mid);
                RecursiveTask<Integer> right = new MaxTask(list, mid, high);

//                right.fork();
//                left.fork();
//                return new Integer(Math.max(left.join().intValue(), right.join().intValue()));
                invokeAll(left, right);
                return new Integer(Math.max(left.join().intValue(), right.join().intValue()));
            }
        }
    }
}
