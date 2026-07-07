package app.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 基本用法示例。
 *
 * ReentrantLock 是 java.util.concurrent.locks 包下提供的显式锁，
 * 功能与 synchronized 关键字类似，但提供了更灵活的加锁/解锁控制。
 */
public class ReentrantLockDemo {

    // 共享票数
    private int ticket = 100;

    // 显式锁，用于保护共享资源
    private final Lock lock = new ReentrantLock();

    /**
     * 售票方法：使用 lock() / unlock() 包裹临界区代码。
     * 注意：unlock() 必须放在 finally 块中，保证锁一定会被释放。
     */
    public void saleTicket() {
        while (true) {
            lock.lock();
            try {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " 正在卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();

        // 三个窗口共同售卖同一份票
        Thread t1 = new Thread(demo::saleTicket, "窗口1");
        Thread t2 = new Thread(demo::saleTicket, "窗口2");
        Thread t3 = new Thread(demo::saleTicket, "窗口3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("售票结束，剩余票数：" + demo.ticket);
    }
}
