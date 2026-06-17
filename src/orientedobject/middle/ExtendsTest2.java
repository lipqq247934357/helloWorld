package orientedobject.middle;

public class ExtendsTest2 {

    public static void main(String[] args) {

        Order order = new Order();
        // 对象不能访问类的private成员
        // order.privateOrderId = 1;
        order.defaultOrderId = 1;
        order.protectedOrderId = 1;
        order.publicOrderId = 1;
        // 不能访问类的private方法
        // order.setPrivateOrderId();
        // 不同包下，子类不能访问类的default成员，这是在同一个包下
        order.setDefaultOrderId();
        order.setProtectedOrderId();
        order.setPublicOrderId();

        SubOrder subOrder = new SubOrder();
        // 子类对象不能访问父类的private成员
        // subOrder.privateOrderId = 1;
        // 不同包下，子类不能访问父类的default成员，这是在同一个包下
        subOrder.defaultOrderId = 1;
        subOrder.protectedOrderId = 1;
        subOrder.publicOrderId = 1;
        // 不能访问类的private方法
        // subOrder.setPrivateOrderId();
        subOrder.setDefaultOrderId();
        subOrder.setProtectedOrderId();
        subOrder.setPublicOrderId();
    }

}

class Order {

    private int privateOrderId;
    int defaultOrderId;
    protected int protectedOrderId;
    public int publicOrderId;

    private void setPrivateOrderId() {
        System.out.println("Order");
    }
    void setDefaultOrderId() {
        System.out.println("Order");
    }
    protected void setProtectedOrderId() {
        System.out.println("Order");
    }
    public void setPublicOrderId() {
        System.out.println("Order");
    }

}

class SubOrder extends Order {
}

