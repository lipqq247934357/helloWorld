# 线程（Thread）

## 创建线程的两种方式

### 方式一：继承 `Thread` 类

1. 自定义类继承 `Thread`。
2. 重写 `run()` 方法，将线程要执行的逻辑放入其中。
3. 创建该类的实例，调用 `start()` 方法启动线程。

```java
class MyThread extends Thread {
    @Override
    public void run() {
        // 线程执行体
    }
}

MyThread t = new MyThread();
t.start();
```

### 方式二：实现 `Runnable` 接口

1. 自定义类实现 `Runnable` 接口。
2. 重写 `run()` 方法。
3. 将实现类实例作为参数传给 `Thread` 构造器。
4. 调用 `Thread` 实例的 `start()` 方法启动线程。

```java
class MyTask implements Runnable {
    @Override
    public void run() {
        // 线程执行体
    }
}

MyTask task = new MyTask();
Thread t = new Thread(task);
t.start();
```

### 说明

- 启动线程必须调用 `start()`，而不是直接调用 `run()`。
- 推荐优先使用 **实现 `Runnable` 接口** 的方式，因为 Java 不支持多继承，实现接口更灵活。
- 可以使用匿名类实现 `Runnable` 接口，从而避免创建额外的类。

## 线程当中常用方法和构造器

    - `start()`：启动线程。
    - `run()`：线程执行体。
    - `currentThread()`：返回当前正在执行的线程。
    - `sleep(long millis)`：使当前线程暂停执行，指定时间后继续执行。
    - `yield()`：提示线程调度器当前线程愿意让出CPU，但不 guarantee。
    - `join()`：等待当前线程执行完毕。
    - `isAlive()`：判断线程是否还活着。
    - `getName()`：获取线程名称。
    - `setName(String name)`：设置线程名称。

## 线程安全

当多个线程同时访问共享资源时，可能会引发数据不一致的问题。Java 主要通过 `synchronized` 关键字来保证线程安全。

### 同步代码块

使用 `synchronized (obj)` 将需要互斥执行的代码包裹起来，`obj` 是多个线程共同认可的锁对象。

```java
synchronized (obj) {
    // 同一时刻只有一个线程能执行这里的代码
}
```

- `obj` 必须是多个线程共享的对象，通常使用共享资源本身或 `this`。

### 同步方法

在方法声明上加上 `synchronized`，锁住的是当前实例对象（`this`）。

```java
public synchronized void method() {
    // 同一时刻只有一个线程能执行该方法
}
```

### 静态同步方法

静态方法上的 `synchronized` 锁住的是当前类的 `Class` 对象。

```java
public static synchronized void staticMethod() {
    // 同一时刻只有一个线程能执行该静态方法
}
```

### 说明

- `synchronized` 可以保证原子性、可见性和有序性。
- 同步代码块比同步方法更灵活，可以只锁定必要的代码，减少锁的粒度。
- 锁对象的选择要合理，避免使用可能被改变的引用类型作为锁对象。

## 死锁

### 死锁的原因

    1. 互斥：资源一次只能被一个线程占用。
    2. 占有且等待：线程持有至少一个资源，同时又在等待其他线程持有的资源。    
    3. 不可剥夺：线程持有的资源在未使用完之前不能被其他线程强行夺取。
    4. 循环等待：线程之间形成头尾相接的循环等待资源关系。

## 显式锁（Lock）

除了 `synchronized` 关键字，Java 在 `java.util.concurrent.locks` 包下还提供了一套更灵活的显式锁机制。`lock` 目录下包含三个典型示例：

### ReentrantLock

`ReentrantLock` 是最常用的显式锁，功能与 `synchronized` 类似，但支持手动加锁/解锁、可中断、可超时等高级特性。

```java
private final Lock lock = new ReentrantLock();

public void saleTicket() {
    while (true) {
        lock.lock();
        try {
            // 临界区代码
        } finally {
            lock.unlock();  // 必须在 finally 中释放锁
        }
    }
}
```

- `lock.lock()`：获取锁，若锁被占用则阻塞等待。
- `lock.unlock()`：释放锁，必须放在 `finally` 块中，保证即使发生异常也能释放。

### ReentrantReadWriteLock

`ReentrantReadWriteLock` 将锁分为读锁和写锁，适合读多写少的场景：

- **读锁**：允许多个线程同时获取，读与读之间不互斥。
- **写锁**：同一时刻只允许一个线程获取，写与写、写与读之间互斥。

```java
private final ReadWriteLock rwLock = new ReentrantReadWriteLock();

public void read() {
    rwLock.readLock().lock();
    try {
        // 读操作
    } finally {
        rwLock.readLock().unlock();
    }
}

public void write(int newValue) {
    rwLock.writeLock().lock();
    try {
        // 写操作
    } finally {
        rwLock.writeLock().unlock();
    }
}
```

### Condition

`Condition` 是与 `Lock` 配合使用的等待/唤醒机制，可以替代 `Object.wait()/notify()`，并且一个 `Lock` 可以创建多个 `Condition`，实现更精细的线程协作。

```java
private final Lock lock = new ReentrantLock();
private final Condition notFull = lock.newCondition();
private final Condition notEmpty = lock.newCondition();

public void produce() throws InterruptedException {
    lock.lock();
    try {
        while (count >= 10) {
            notFull.await();  // 库存已满，生产者等待
        }
        count++;
        notEmpty.signalAll(); // 唤醒消费者
    } finally {
        lock.unlock();
    }
}

public void consume() throws InterruptedException {
    lock.lock();
    try {
        while (count <= 0) {
            notEmpty.await(); // 库存为空，消费者等待
        }
        count--;
        notFull.signalAll();  // 唤醒生产者
    } finally {
        lock.unlock();
    }
}
```

### 说明

- 显式锁比 `synchronized` 更灵活，但需要手动管理锁的获取和释放，容易因遗漏 `unlock()` 导致死锁。
- `ReentrantLock` 和 `ReentrantReadWriteLock` 都支持公平锁和非公平锁，默认使用非公平锁。
- 使用 `Condition` 时，必须在持有对应 `Lock` 的前提下调用 `await()` 和 `signal()`。


## 线程之间的通信

线程之间往往不是独立运行的，一个线程的执行可能依赖另一个线程的状态或结果。Java 中常见的线程通信方式包括 `wait()/notify()`、`join()` 以及共享变量等。

### 使用 `wait()` / `notify()` / `notifyAll()`

`Object` 类提供的这三个方法是 Java 最基础的线程通信机制，必须在 ` 同步代码块或同步方法中 `调用。

- `wait()`：使当前线程释放锁并进入等待状态，直到被其他线程唤醒。
- `notify()`：随机唤醒一个正在等待该对象锁的线程。
- `notifyAll()`：唤醒所有正在等待该对象锁的线程。

```java
public class CommunicationDemo {
    private boolean flag = false;

    public synchronized void produce() throws InterruptedException {
        while (flag) {
            wait();  // 已经生产过，等待消费
        }
        // 生产数据
        flag = true;
        notifyAll();  // 唤醒消费者
    }

    public synchronized void consume() throws InterruptedException {
        while (!flag) {
            wait();  // 还没有数据，等待生产
        }
        // 消费数据
        flag = false;
        notifyAll();  // 唤醒生产者
    }
}
```

### 使用 `join()`

`join()` 方法用于让当前线程等待另一个线程执行完毕后再继续执行。

```java
Thread t = new Thread(() -> {
    // 子线程任务
});
t.start();
t.join();  // 主线程阻塞，直到 t 执行完成
```

### 使用共享变量

线程可以通过共享变量来传递状态，但需要配合 `synchronized` 或 `volatile` 来保证可见性和有序性。

```java
private volatile boolean running = true;

public void stop() {
    running = false;  // 一个线程修改标志，另一个线程可见
}
```

### 说明

- 调用 `wait()` / `notify()` 时，当前线程必须持有该对象的锁，否则会抛出 `IllegalMonitorStateException`。
- 唤醒后通常使用 `while` 循环重新检查条件，防止「虚假唤醒」。
- `notify()` 只唤醒一个等待线程，`notifyAll()` 更安全，能避免漏唤醒导致线程永久等待。
- 相比 `wait()/notify()`，`Lock + Condition` 可以实现多个不同的等待队列，控制更精细。

### sleep 和 await 的异同

`Thread.sleep()` 和 `Condition.await()` 都会让当前线程暂停执行，但它们的语义、使用场景和锁行为完全不同。

| 对比项 | `Thread.sleep(long millis)` | `Condition.await()` |
|--------|---------------------------|---------------------|
| 所属类 | `Thread` 的静态方法 | `Condition` 的实例方法 |
| 使用前提 | 无特殊要求 | 必须先获取对应的 `Lock` |
| 是否释放锁 | **不释放**任何锁 | **会释放**关联的 `Lock` |
| 唤醒方式 | 到达指定时间后自动唤醒 | 需要其他线程调用 `signal()` / `signalAll()` |
| 中断响应 | 会抛出 `InterruptedException` | 会抛出 `InterruptedException` |
| 典型用途 | 让线程暂停一段时间 | 线程等待某个条件成立 |

```java
// sleep：只是暂停，不释放锁
synchronized (obj) {
    Thread.sleep(1000);  // 抱着锁睡觉
}
```

```java
// await：会释放锁，进入等待队列
lock.lock();
try {
    while (条件不满足) {
        condition.await();  // 释放 lock，当前线程等待被 signal
    }
} finally {
    lock.unlock();
}
```

### 补充：sleep 和 wait 的区别

`Thread.sleep()` 和 `Object.wait()` 的区别与上表类似：

- `sleep()` 不释放锁，`wait()` 会释放锁。
- `sleep()` 是 `Thread` 的静态方法，`wait()` 是 `Object` 的实例方法。
- `sleep()` 到时间自动醒，`wait()` 需要被 `notify()` / `notifyAll()` 唤醒。
- `wait()` 必须在 `synchronized` 块内调用，`sleep()` 没有此限制。

### 一句话总结

- **`sleep`**：线程暂停一段时间，锁还攥在手里。
- **`wait` / `await`**：线程因为条件不满足而等待，会主动释放锁，等待被唤醒后重新竞争锁。