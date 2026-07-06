package app.thread.safe;

public class SalesWindow2 implements Runnable {

    private int ticket = 3000;

    @Override
    public synchronized void run() {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "正在卖票，票号为：" + ticket);
            ticket--;
        }
    }
}
