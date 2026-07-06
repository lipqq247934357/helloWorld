package app.thread;

public class ThreadTest2 {

    public static void main(String[] args) {
        InputNumber2 inputNumber2 = new InputNumber2();
        Thread thread = new Thread(inputNumber2);
        thread.start();
    }
}

class InputNumber2 implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}