package chapter.chapter01;

public class helloWorld {

    public static void main(String[] args) {
        sayHello();
    }

    public static void sayHello() {
        Person p = new Son();
        System.out.println(p.age);  // 10，属性看左边声明类型 Person
        p.show();                    // Son，方法看右边实际对象 Son

    }
}

class Person {
    int age = 10;
    void show() { System.out.println("Person"); }
}
class Son extends Person {
    int age = 20;
    @Override
    void show() { System.out.println("Son"); }
}