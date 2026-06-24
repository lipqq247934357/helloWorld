package orientedobject.middle;

public class ExtendsTest4 {

    public static void main(String[] args) {
        Children student = new Children("张三", 18);
        System.out.println("student.age = " + student.age);
        student.setAge(18);
        student.setSuperAge(28);
        System.out.println("student.age = " + student.age);
        int age = student.getSuperAge(28);
        System.out.println("super age = " + age);
        student.setAllAge(6, 16);
        age = student.getSuperAge(28);
        System.out.println("age superAage:  " + student.age + " " + age);
    }

}

class PersonInfo {
    public PersonInfo() {
        this.age = 20;
        System.out.println("PersonInfo");
    }

    public String name;
    public int age;

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

class Children extends PersonInfo {
    public Children(String name, int age) {
        super();
        System.out.println("Children");
    }
    public int age;
    public void setName (String name) {
        this.name = name + "(学生)";
    }
    // 只能指定更宽的，或一样的访问权限，不能指定更窄的访问权限，比如这里不能指定为private类型；
    public void setAge(int age) {
        this.age = age;
    }
    // 只能指定更宽的，或一样的返回值类型，不能指定更窄的返回值类型，比如这里不能指定返回值为char类型
    public int getAge() {
        return this.age;
    }
    public void setSuperAge(int age) {
        super.age = age;
    }
    public int getSuperAge(int age) {
        return super.age;
    }
    public void getAllAge(int age) {
        System.out.println(super.age);
        System.out.println(age);
    }
    public void setAllAge(int age, int superAge) {
        this.setAge(age);
        super.setAge(superAge);
    }
}


