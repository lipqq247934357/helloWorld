package orientedobject.senior;

/**
 * 类加载顺序与对象初始化顺序演示
 * 口诀：由父及子，静态先行
 */
class Father {

    static {
        System.out.println("Father 静态代码块");
    }

    {
        System.out.println("Father 实例代码块");
    }

    int age = 10;

    public Father() {
        System.out.println("Father 构造方法");
        System.out.println(this instanceof Father);
        System.out.println(this instanceof Son);
        System.out.println(this);
        age = 20;
    }
}

class Son extends Father {

    static {
        System.out.println("Son 静态代码块");
    }

    {
        System.out.println("Son 实例代码块");
    }

    int age = 30;

    public Son() {
        System.out.println("Son 构造方法");
        age = 40;
    }
    public int getPAge() {
        return super.age;
    }
}

public class LoadingOrderDemo {

    public static void main(String[] args) {
        System.out.println("--- 第一次创建 Son 对象 ---");
        Son s1 = new Son();
        System.out.println("s1.age " + s1.age);
        System.out.println("s1.getPAge() " + s1.getPAge());
        System.out.println("--- 第二次创建 Son 对象 ---");
        new Son();
    }
}
