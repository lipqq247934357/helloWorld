package app.thread.safe;

public class WinodwTest1 {

//    public static void main(String[] args) {
//        Runnable r1 = new SalesWindow();
//        Thread t1 = new Thread(r1, "窗口1");
//        Thread t2 = new Thread(r1, "窗口2");
//        Thread t3 = new Thread(r1, "窗口3");
//        t1.start();
//        t2.start();
//        t3.start();
//    }

    public static void main(String[] args) {
        Runnable r2 = new SalesWindow2();
        Thread t1 = new Thread(r2, "窗口1");
        Thread t2 = new Thread(r2, "窗口2");
        Thread t3 = new Thread(r2, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
