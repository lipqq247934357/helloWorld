package orientedobject.basic;

public class classTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.brand = "华为";
        phone.price = 1999;
        phone.color = "黑色";
        phone.call();
        phone.sendMessage();
        System.out.println(phone.brand + " " + phone.price + " " + phone.color);
        phone.show();
    }
}

class Phone {

    String brand;
    int price;
    String color;

    public void call() {
        System.out.println("打电话");
    }

    public void sendMessage() {
        System.out.println("发短信");

    }

    public void show() {
        System.out.println("品牌：" + brand + "，价格：" + price + "，颜色：" + color);
    }
}
