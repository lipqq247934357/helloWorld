package app.thread;

public class ThreadTest3 {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread is running");
            }
        }).start();
    }
}

