package app.thread;

public class ThreadTest1 {

    public static void main(String[] args) {
        PrintNumber p1 = new PrintNumber();
        PrintNumber p2 = new PrintNumber();
        p1.start();
        p2.start();
    }
}

class PrintNumber extends Thread {
    private int number = 1;
    public void run() {
        for (int i = 0; i< 100;i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i + " " + number++);
        }
    }
}
