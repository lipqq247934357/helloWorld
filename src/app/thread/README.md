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

## 说明

- 启动线程必须调用 `start()`，而不是直接调用 `run()`。
- 推荐优先使用 **实现 `Runnable` 接口** 的方式，因为 Java 不支持多继承，实现接口更灵活。
