package orientedobject.senior;

/**
 * 内部类（Inner Class）用法演示
 *
 * 核心要点：
 * 1. 内部类定义在另一个类的内部，可以访问外部类的所有成员（包括 private）；
 * 2. 成员内部类：依附于外部类实例，不能声明静态成员（JDK 16 之前）；
 * 3. 静态内部类：使用 static 修饰，不依赖外部类实例，可以声明静态成员；
 * 4. 局部内部类：定义在方法或代码块内部，作用域仅限于该方法或代码块；
 * 5. 匿名内部类：没有名字，通常用于一次性实现接口或抽象类。
 */
public class InnerClassDemo {

    private String outerName = "外部类成员变量";
    private static String outerStaticName = "外部类静态变量";

    /**
     * 成员内部类
     */
    class MemberInner {
        private String innerName = "成员内部类变量";

        public void show() {
            System.out.println("成员内部类访问外部类私有变量：" + outerName);
            System.out.println("成员内部类访问外部类静态变量：" + outerStaticName);
            System.out.println("成员内部类自己的变量：" + innerName);
        }
    }

    /**
     * 静态内部类
     */
    static class StaticInner {
        private String staticInnerName = "静态内部类变量";
        private static String staticInnerStaticName = "静态内部类静态变量";

        public void show() {
            // 静态内部类不能直接访问外部类的非静态成员
            System.out.println("静态内部类访问外部类静态变量：" + outerStaticName);
            System.out.println("静态内部类自己的变量：" + staticInnerName);
            System.out.println("静态内部类自己的静态变量：" + staticInnerStaticName);
        }
    }

    /**
     * 演示局部内部类
     */
    public void useLocalInner() {
        final String localVar = "方法局部变量";

        // 局部内部类：只能在当前方法中使用
        class LocalInner {
            public void show() {
                System.out.println("局部内部类访问外部类私有变量：" + outerName);
                System.out.println("局部内部类访问方法局部变量：" + localVar);
            }
        }

        LocalInner localInner = new LocalInner();
        localInner.show();
    }

    /**
     * 演示匿名内部类：作为参数传入
     */
    public void useAnonymousInner() {
        // 匿名内部类实现接口
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("匿名内部类说：你好！");
            }
        };
        greeting.sayHello();
    }

    public static void main(String[] args) {
        InnerClassDemo outer = new InnerClassDemo();

        // 1. 成员内部类：必须通过外部类实例创建
        System.out.println("===== 成员内部类 =====");
        MemberInner memberInner = outer.new MemberInner();
        memberInner.show();

        System.out.println("===== 静态内部类 =====");
        // 2. 静态内部类：不依赖外部类实例
        StaticInner staticInner = new StaticInner();
        staticInner.show();

        System.out.println("===== 局部内部类 =====");
        // 3. 局部内部类：在外部类的方法中定义和使用
        outer.useLocalInner();

        System.out.println("===== 匿名内部类 =====");
        // 4. 匿名内部类：通常用于一次性场景
        outer.useAnonymousInner();

        // 5. 匿名内部类直接创建对象并调用
        new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("直接 new 的匿名内部类说：Hello World！");
            }
        }.sayHello();
    }
}

/**
 * 供匿名内部类实现的接口
 */
interface Greeting {
    void sayHello();
}
