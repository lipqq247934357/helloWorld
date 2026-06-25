package orientedobject.senior;

/**
 * 单例模式：保证一个类只有一个实例，并提供一个全局访问点。
 * 本例使用静态内部类实现，兼具懒加载和线程安全。
 */
public class SingleTon {

    // 私有化构造方法，防止外部通过 new 创建实例
    private SingleTon() {
    }

    // 静态内部类，在首次使用时才会加载，实现懒加载
    private static class SingletonHolder {
        private static final SingleTon INSTANCE = new SingleTon();
    }

    // 全局访问点
    public static SingleTon getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void sayHello() {
        System.out.println("Hello, Singleton!");
    }

    public static void main(String[] args) {
        SingleTon s1 = SingleTon.getInstance();
        SingleTon s2 = SingleTon.getInstance();
        System.out.println(s1 == s2); // true，说明是同一个对象
        s1.sayHello();
    }
}
