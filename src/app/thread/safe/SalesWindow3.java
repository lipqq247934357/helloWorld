package app.thread.safe;

/**
 * 继承Thread类
 *  创建一个继承Thread类的子类
 *  使用synchronized装饰方法；避免线程安全问题
 */

public class SalesWindow3 extends Thread {

    private static int ticket = 3000;

    public void run() {
        show();
    }

    public static synchronized void show() {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "正在卖票，票号为：" + ticket);
            ticket--;
        }
    }
}
