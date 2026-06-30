package orientedobject.senior;

/**
 * 接口（interface）用法演示
 *
 * 核心要点：
 * 1. 接口是一种规范，表示“能做什么”；
 * 2. 接口中的属性默认是 public static final（常量）；
 * 3. 接口中的方法在 JDK 8 之前默认是 public abstract；
 * 4. 一个类可以实现多个接口，弥补 Java 单继承的不足；
 * 5. 接口不能实例化，也不能声明构造方法、代码块。
 */
public class InterfaceDemo {

    public static void main(String[] args) {
        // 1. 接口不能 new 对象
        // Flyable f = new Flyable(); // 编译错误

        // 2. 接口常量
        System.out.println("最大飞行高度：" + Flyable.MAX_HEIGHT);

        System.out.println("------------");

        // 3. 多态：接口引用指向实现类对象
        Flyable bird = new Bird();
        bird.fly();

        System.out.println("------------");

        Flyable plane = new Plane();
        plane.fly();

        System.out.println("------------");

        // 4. 一个类实现多个接口
        Duck duck = new Duck();
        duck.fly();
        duck.run();
        duck.swim();
    }
}

/**
 * 接口：会飞
 */
interface Flyable {

    // 接口中的属性默认 public static final
    int MAX_HEIGHT = 10000;

    // 接口中的方法默认 public abstract
    void fly();

    // JDK 8 开始支持 default 方法，有方法体，实现类可选择性重写
    default void land() {
        System.out.println("正在降落");
    }
}

/**
 * 接口：会跑
 */
interface Runnable {

    void run();
}

/**
 * 接口：会游泳
 */
interface Swimmable {

    void swim();
}

/**
 * 实现类：鸟，会飞
 */
class Bird implements Flyable {

    @Override
    public void fly() {
        System.out.println("小鸟拍打翅膀飞行");
    }
}

/**
 * 实现类：飞机，也会飞
 */
class Plane implements Flyable {

    @Override
    public void fly() {
        System.out.println("飞机依靠引擎飞行");
    }
}

/**
 * 实现类：鸭子，会飞、会跑、会游泳
 */
class Duck implements Flyable, Runnable, Swimmable {

    @Override
    public void fly() {
        System.out.println("鸭子低空飞行");
    }

    @Override
    public void run() {
        System.out.println("鸭子摇摇摆摆地跑");
    }

    @Override
    public void swim() {
        System.out.println("鸭子在水里游");
    }
}
