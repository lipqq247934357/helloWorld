package app.thread.lock;

/**
 *
 * 需求：
 * 1.生产者，消费者，店员；
 * 2.生产者生产商品，店员上架，消费者消费商品；
 * 3.店员用于产品的数量信息，以及产品的上架和下架操作；
 * 4.生产者生产商品，消费者消费商品；
 *
 */

public class Test {

    private int productNum = 0;

    private final int MAX_PRODUCT = 30;
    private final int ADD_NUM = 10;

    private synchronized void uploadProduct() {
        while (productNum + ADD_NUM > MAX_PRODUCT) {
            try {
                wait();   // 满了就等消费者
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        productNum = productNum + ADD_NUM;
        System.out.println("生产者生产了一个商品，当前商品数量为：" + productNum);
        notifyAll();
    }

    private synchronized void sellProduct() {
        while (productNum == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        productNum--;
        System.out.println("消费者消费了一个商品，剩余商品数量为：" + productNum);
        notifyAll();
    }

    public static void main(String[] args) {

        Test t = new Test();

        Runnable customer = () -> {
            for (int i = 0; i < 50; i++) {
                t.sellProduct();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable producer = () -> {
            for (int i = 0; i < 10; i++) {
                t.uploadProduct();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread c1 = new Thread(customer);
        Thread c2 = new Thread(customer);
        Thread p1 = new Thread(producer);

        p1.start();
        c1.start();
        c2.start();

        try {
            p1.join();
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

