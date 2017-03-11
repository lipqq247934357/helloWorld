package desginPattern.adapterPattern.objectadapter;

public class Entity2 {


    Entity1 e;

    public void hehe(){
        e = new Entity1();
        e.method1();
    }
    
    public void method2(){
        
        System.out.println("method2");
        
    }
}
