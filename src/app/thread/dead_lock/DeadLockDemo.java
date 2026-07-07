package app.thread.dead_lock;

/**
 * 死锁示例：两个线程互相持有对方需要的锁，导致程序无法继续执行。
 *
 * 产生死锁的四个必要条件：
 * 1. 互斥：资源一次只能被一个线程占用。
 * 2. 占有且等待：线程持有至少一个资源，同时又在等待其他线程持有的资源。
 * 3. 不可剥夺：线程持有的资源在未使用完之前不能被其他线程强行夺取。
 * 4. 循环等待：线程之间形成头尾相接的循环等待资源关系。
 */
public class DeadLockDemo {

    // 两个共享资源，作为锁对象
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        // 线程 1：先获取 lockA，再尝试获取 lockB
        Thread thread1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + "：已持有 lockA");
                try {
                    // 模拟业务处理，增加死锁出现的概率
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "：尝试获取 lockB...");
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + "：成功获取 lockB");
                }
            }
        }, "线程1");

        // 线程 2：先获取 lockB，再尝试获取 lockA
        Thread thread2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "：已持有 lockB");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "：尝试获取 lockA...");
                synchronized (lockA) {
                    System.out.println(Thread.currentThread().getName() + "：成功获取 lockA");
                }
            }
        }, "线程2");

        thread1.start();
        thread2.start();

        // 等待两个线程执行完毕（实际上会死锁，不会结束）
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("程序结束");
    }
}
