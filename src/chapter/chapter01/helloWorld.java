package chapter.chapter01;

import java.util.Date;

public class helloWorld {

    public static void main(String[] args) {
        sayHello();
    }

    public static void sayHello() {
        Person p = new Son();
        p.getUseTime();
    }
}

abstract class Person {
    abstract void show();
    public void getUseTime() {

        Date before = new Date();
        System.out.println(before.getTime());
        show();
        Date after = new Date();
        System.out.println(after.getTime());
        System.out.println("use time: " + (after.getTime() - before.getTime()));
    }
}
class Son extends Person {
    @Override
    void show() {
        System.out.println("Son");
        System.out.println("Son");
        System.out.println("Son");
        System.out.println("Son");
        System.out.println("Son");
    }
}