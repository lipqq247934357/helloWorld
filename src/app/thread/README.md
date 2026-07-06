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