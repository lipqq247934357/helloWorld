package orientedobject.middle.Polym;

public class PolymTest1 {
    public static void main(String[] args) {
        Person p = new Man(1);
        p.eat();
        p.getId();
        ((Man) p).earnMoney();
    }
}

class Person {
    public Person(int id) {
        this.id = id;
    }
    int id;
    public void eat() {
        System.out.println("Person eat");
    }
    public void getId() {
        System.out.println("Person id:" + id);
    }
}

class Man extends Person {
    public Man(int id) {
        super(1);
    }
    public void eat() {
        System.out.println("Man eat");
    }
    public void earnMoney() {
        System.out.println("Man earn money");
    }
}

class Woman extends Person {
    public Woman(int id) {
        super(id);
    }
    public void eat() {
        System.out.println("Woman eat");
    }
}