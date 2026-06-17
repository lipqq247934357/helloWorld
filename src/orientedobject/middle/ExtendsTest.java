package orientedobject.middle;

public class ExtendsTest {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "Buddy";
        dog.getName();
        dog.eat();
        dog.bark();
    }

}

class Animal {
    String name;
    void getName() {
        System.out.println("The name of the animal is " + name);
    }

    void eat() {
        System.out.println("This animal eats food");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("The dog barks");
    }
}
