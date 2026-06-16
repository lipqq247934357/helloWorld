package orientedobject.basic;

public class FunctionOverload {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.brand = "华为";
        phone.price = 1999;
        phone.color = "黑色";
        phone.call();
        phone.sendMessage();
        System.out.println(phone.brand + " " + phone.price + " " + phone.color);
        System.out.println("================================");
        phone.show();
        phone.show("华为", 1999, "黑色");
        phone.show("华为");
        phone.show("华为", "小米", "oppo", "vivo", "魅族", "锤子", "一加");
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

    public void show(String brand, int price, String color) {
        System.out.println("品牌：" + brand + "，价格：" + price + "，颜色：" + color);
    }

    public void show(String brand) {
        System.out.println("品牌：" + brand);
    }

    public void show(String... brands) {
        StringBuilder str = new StringBuilder();
        for (String brand : brands) {
            str.append(brand).append(" ");
        }
        System.out.println("品牌：" + str);
    }

    // String... brands 等价于 String[] brands;所以不能同时存在；
    // public void show(String[] brands) {
    //     System.out.println("价格：" + price);
    // }
}
