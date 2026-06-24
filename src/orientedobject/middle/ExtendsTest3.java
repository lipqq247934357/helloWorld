package orientedobject.middle;

public class ExtendsTest3 {

    public static void main(String[] args) {

        Student student = new Student();
        student.setName("张三");
        student.setAge(18);
        student.setAge(28);
        System.out.println(student.name + " " + student.age);
    }

}

class People {
    public People() {
        System.out.println("People");
    }

    public String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }
    void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }
}

class Student extends People {
    public Student() {
        super();
        System.out.println("Student");
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
}


