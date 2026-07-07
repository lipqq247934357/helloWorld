package app.thread.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock 读写锁示例。
 *
 * 读写锁将锁分为读锁和写锁：
 * - 读锁：允许多个线程同时获取，适合读多写少的场景。
 * - 写锁：同一时刻只允许一个线程获取，且写锁与读锁互斥。
 */
public class ReadWriteLockDemo {

    // 共享数据
    private int value = 0;

    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();

    /**
     * 读操作：使用读锁，多个读线程可以并发执行。
     */
    public void read() {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "：读取到 value = " + value);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }

    /**
     * 写操作：使用写锁，保证写操作的互斥性。
     */
    public void write(int newValue) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "：准备写入 value = " + newValue);
            value = newValue;
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + "：写入完成，当前 value = " + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();

        // 三个读线程
        Runnable readTask = () -> {
            for (int i = 0; i < 3; i++) {
                demo.read();
            }
        };

        // 两个写线程
        Runnable writeTask = () -> {
            for (int i = 0; i < 3; i++) {
                demo.write((int) (Math.random() * 100));
            }
        };

        Thread r1 = new Thread(readTask, "读线程1");
        Thread r2 = new Thread(readTask, "读线程2");
        Thread r3 = new Thread(readTask, "读线程3");
        Thread w1 = new Thread(writeTask, "写线程1");
        Thread w2 = new Thread(writeTask, "写线程2");

        r1.start();
        r2.start();
        r3.start();
        w1.start();
        w2.start();

        try {
            r1.join();
            r2.join();
            r3.join();
            w1.join();
            w2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最终 value = " + demo.value);
    }
}
