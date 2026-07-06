package app.thread.safe;

public class WinodwTest1 {

    public static void main(String[] args) {
//        Runnable r1 = new SalesWindow();
//        Thread t1 = new Thread(r1, "窗口1");
//        Thread t2 = new Thread(r1, "窗口2");
//        Thread t3 = new Thread(r1, "窗口3");
//        t1.start();
//        t2.start();
//        t3.start();

//        Runnable r2 = new SalesWindow2();
//        Thread t1 = new Thread(r2, "窗口1");
//        Thread t2 = new Thread(r2, "窗口2");
//        Thread t3 = new Thread(r2, "窗口3");
//        t1.start();
//        t2.start();
//        t3.start();

        SalesWindow3 s1 = new SalesWindow3();
        SalesWindow3 s2 = new SalesWindow3();
        SalesWindow3 s3 = new SalesWindow3();
        s1.start();
        s2.start();
        s3.start();
    }

}
