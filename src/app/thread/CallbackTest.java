package app.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallbackTest {

    public static void main(String[] args) {
        // 1. 创建 Callable 任务
        NumThread numThread = new NumThread();

        // 2. 使用 FutureTask 包装 Callable，FutureTask 实现了 Runnable
        FutureTask<Integer> futureTask = new FutureTask<>(numThread);

        // 3. 将 FutureTask 作为 Runnable 传给 Thread 启动线程
        Thread thread = new Thread(futureTask);
        thread.start();

        // 4. 通过 FutureTask 获取线程执行结果（get() 会阻塞直到任务完成）
        try {
            Integer result = futureTask.get();
            System.out.println("子线程返回结果：" + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class NumThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + " 计算完成，sum = " + sum);
        return sum;
    }
}