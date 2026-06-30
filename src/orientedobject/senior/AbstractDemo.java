package orientedobject.senior;

/**
 * 抽象类（abstract class）用法演示
 *
 * 核心要点：
 * 1. 抽象类不能实例化；
 * 2. 抽象方法只有声明，没有方法体；
 * 3. 子类必须重写父类中所有的抽象方法，否则子类也必须声明为抽象类；
 * 4. 抽象类中可以包含普通成员变量、普通方法、构造方法，用于给子类复用。
 */
public class AbstractDemo {

    public static void main(String[] args) {
        // 1. 抽象类不能 new 对象
        // Animal animal = new Animal(); // 编译错误

        // 2. 多态：父类引用指向子类对象
        Animal dog = new Dog("旺财");
        dog.makeSound(); // 实际执行 Dog 重写的方法
        dog.sleep();

        System.out.println("------------");

        Animal cat = new Cat("咪咪");
        cat.makeSound();
        cat.sleep();

        System.out.println("------------");

        // 3. 子类对象实例化时会调用父类构造方法
        Dog d = new Dog("大黄");
        System.out.println("狗狗名字：" + d.getName());
    }
}

/**
 * 抽象类：动物
 */
abstract class Animal {

    private String name;

    // 抽象类可以有构造方法，供子类调用
    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 抽象方法：只有声明，没有方法体
    public abstract void makeSound();

    // 普通方法：子类可以直接继承使用
    public void sleep() {
        System.out.println(name + " 正在睡觉");
    }
}

/**
 * 具体子类：狗
 */
class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + "：汪汪汪");
    }
}

/**
 * 具体子类：猫
 */
class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + "：喵喵喵");
    }
}

/**
 * 抽象子类：没有重写所有抽象方法，所以自身也必须声明为 abstract
 */
abstract class Fish extends Animal {

    public Fish(String name) {
        super(name);
    }

    // Fish 没有重写 makeSound，因此 Fish 也必须是抽象类
}
