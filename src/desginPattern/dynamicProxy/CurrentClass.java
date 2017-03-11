package desginPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CurrentClass implements InvocationHandler{

    public void hehe(){
        System.out.println("hehe");
        Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), this.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
    
}
