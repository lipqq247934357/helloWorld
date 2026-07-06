package app.thread;

public class ThreadTest1 {

    public static void main(String[] args) {
        PrintNumber p1 = new PrintNumber(100);
        PrintNumber p2 = new PrintNumber(200);
        p1.start();
        p2.start();
    }
}

class PrintNumber extends Thread {
    private int number;
    public PrintNumber(int number) {
        this.number = number;
    }
    public void run() {
        for (int i = 0; i< 1000;i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i + " " + number);
        }
    }
}
