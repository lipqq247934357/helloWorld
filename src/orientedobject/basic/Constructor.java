package orientedobject.basic;

public class Constructor {

    public static void main(String[] args) {
        Person person = new Person("李四", 21);
        System.out.println(person.name + " " + person.age);
    }
    
}


class Person {
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
}