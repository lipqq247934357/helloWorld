package orientedobject.middle;

public class ThisTest {

    public static void main(String[] args) {
        Person p = new Person("Alice", 30);
        p.display();
    }

}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
