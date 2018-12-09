package testMultithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        //ExecutorService executor = Executors.newFixedThreadPool(2);
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(new PrintChar('a', 100));
        executor.execute(new PrintChar('b', 100));
        executor.execute(new PrintNum(100));

        executor.shutdown();    //executor won't be destroyed if miss this statement
    }
}


