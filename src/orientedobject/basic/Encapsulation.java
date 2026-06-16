package orientedobject.basic;

public class Encapsulation {
    
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.setName("小狗");
        System.out.println(animal.getName());
        animal.eat();
        // 直接访问私有属性会报错
        // animal.name = "小狗";
        // 缺省修饰符，本包内可以访问
        animal.color = "黑色";
        System.out.println(animal.color);
    }
}

class Animal {

    private String name;
    String color;
    public void eat() {
        System.out.println("吃");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        } else {
            System.out.println("名字不能为空");
        }
    }
}
