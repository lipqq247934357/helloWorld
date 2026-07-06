package app.thread.safe;

public class SalesWindow implements Runnable {

    private int ticket = 300;

    @Override
    public void run() {
        while (ticket > 0) {
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在卖票，票号为：" + ticket);
                    ticket--;
                }
            }
        }
    }
}
