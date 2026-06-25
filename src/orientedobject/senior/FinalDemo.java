package orientedobject.senior;

/**
 * final 关键字用法演示
 */
public class FinalDemo {

    // final 成员变量：常量，一旦赋值不能修改
    private final int MAX_SIZE = 100;

    // final 方法：不能被子类重写
    public final void show() {
        System.out.println("FinalDemo show");
    }

    public static void main(String[] args) {
        // 1. final 局部变量
        final int a = 10;
        // a = 20; // 编译错误：不能给 final 变量重新赋值

        // 2. final 引用：引用不能变，但对象内容可以变
        final StringBuilder sb = new StringBuilder("hello");
        sb.append(" world");  // 可以修改对象内部内容
        System.out.println(sb);  // hello world
        // sb = new StringBuilder("new"); // 编译错误：不能改变引用指向

        // 3. final 参数
        printNumber(a);

        FinalDemo demo = new FinalDemo();
        System.out.println("MAX_SIZE = " + demo.MAX_SIZE);
        demo.show();

        FinalClass finalClass = new FinalClass();
        finalClass.sayHello();
    }

    public static void printNumber(final int num) {
        // num = 100; // 编译错误：final 参数不能在方法内修改
        System.out.println("num = " + num);
    }
}

// final 类：不能被继承
final class FinalClass {
    public void sayHello() {
        System.out.println("Hello from final class");
    }
}

// class SubFinalClass extends FinalClass {} // 编译错误：无法继承 final 类
