package desginPattern.adapterPattern.classadapter;

public class Entity2 extends Entity1 implements Source {

    @Override
    public void method2() {
        System.out.println("method2");
    }

    public static void main(String[] args) {
        
       Entity2 e2 = new Entity2();
       
       e2.method1();

       e2.method2();
    }
    
}
