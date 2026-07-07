package app.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock + Condition 实现生产者-消费者模型。
 *
 * Condition 可以替代 Object 的 wait()/notify()，
 * 并且一个 Lock 可以创建多个 Condition，实现更精细的线程等待/唤醒控制。
 */
public class LockConditionDemo {

    // 共享库存
    private int count = 0;

    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    /**
     * 生产者：库存满时等待，生产后唤醒消费者。
     */
    public void produce() throws InterruptedException {
        lock.lock();
        try {
            while (count >= 10) {
                System.out.println(Thread.currentThread().getName() + "：库存已满，等待消费...");
                notFull.await();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "：生产一个产品，当前库存：" + count);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 消费者：库存空时等待，消费后唤醒生产者。
     */
    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (count <= 0) {
                System.out.println(Thread.currentThread().getName() + "：库存为空，等待生产...");
                notEmpty.await();
            }
            count--;
            System.out.println(Thread.currentThread().getName() + "：消费一个产品，当前库存：" + count);
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockConditionDemo demo = new LockConditionDemo();

        // 两个生产者
        Runnable producerTask = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    demo.produce();
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 两个消费者
        Runnable consumerTask = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    demo.consume();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread p1 = new Thread(producerTask, "生产者1");
        Thread p2 = new Thread(producerTask, "生产者2");
        Thread c1 = new Thread(consumerTask, "消费者1");
        Thread c2 = new Thread(consumerTask, "消费者2");

        p1.start();
        p2.start();
        c1.start();
        c2.start();

        try {
            p1.join();
            p2.join();
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最终库存：" + demo.count);
    }
}
