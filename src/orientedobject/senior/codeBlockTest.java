package orientedobject.senior;

public class codeBlockTest {
    public static void main(String[] args) {
        Man man = new Man();
        Man man2 = new Man();
        System.out.println(man.age);
    }
}

class Man {
    // 随着类的加载而执行，只执行一次
    static {
        System.out.println("静态代码块");
    }
    // 随着对象的创建而执行，每次创建对象时都会执行
    {
        System.out.println("实例代码块");
        this.age = 20;
    }

    public Man() {
        age = 30;
        System.out.println("构造方法");
    }


    int age = 10;
}
