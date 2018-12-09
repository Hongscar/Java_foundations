package testMultithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithoutSync {
    private static Account account = new Account();

    private static class Account {
        private static Lock lock = new ReentrantLock();     //create a lock

        private static Semaphore semaphore = new Semaphore(1);

        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
          //  synchronized (Account.class) {      //equals with this!
                //lock.lock();


                try {
                    semaphore.acquire();                //Acquire a permit
                    int newBalance = balance + amount;
                    Thread.sleep(1);
                    balance = newBalance;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();                //Release a permit
                    //lock.unlock();
                }


          //  }
        }
    }

    private static class AddPennyTask implements Runnable {
        public void run() {
            //synchronized (account) {
                account.deposit(1);
            //}
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        //lambda
//        for (int i = 0; i < 1000; i++)
//            executor.execute(new Thread(() -> {
//                account.deposit(1);
//            }));
        for (int i = 0; i < 1000; i++) {
            executor.execute(new AddPennyTask());
        }


        executor.shutdown();

        //wait until all tasks are finished
        while (!executor.isTerminated()) {

        }

        System.out.println(account.getBalance());
    }
}
