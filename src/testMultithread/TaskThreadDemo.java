package testMultithread;

public class TaskThreadDemo{
    public static void main(String[] args) {



        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);

        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);
        thread3.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
        new Thread(() -> {
            System.out.println("qqq");
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("haha");
            }
        }).start();
    }
}

class PrintChar implements Runnable {
    private char charToPrint;
    private int times;

    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++)
            System.out.print(charToPrint);
    }
}

class PrintNum implements Runnable {
    private int lastNum;

    public PrintNum(int n) {
        lastNum = n;
    }

    @Override
    public void run() {
       // Thread thread4 = new Thread(new PrintChar('c', 800));

//        thread4.setPriority(1);
//        thread4.start();


                for (int i = 1; i <= lastNum; i++)
                    System.out.print(" " + i);
                   // if (i == 50) thread4.join();

    }
}
