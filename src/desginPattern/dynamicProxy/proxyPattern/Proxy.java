package desginPattern.dynamicProxy.proxyPattern;

public class Proxy implements Sourceable{

    Source c;
    
    @Override
    public void method() {
        before();
        c = new Source();
        end();
    }
    
    public void before(){
        System.out.println("before c");
    }
    
    public void end(){
        System.out.println("end c");
        
    }

    public static void main(String[] args) {
        
        new Proxy().method();
        
    }
    
}
