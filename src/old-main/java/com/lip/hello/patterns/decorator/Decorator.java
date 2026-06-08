package com.lip.hello.patterns.decorator;

public class Decorator {

    public Source c;
    
    public Decorator(Source c){
        this.c = c;
    }
    
    public void hehe(){
        c.hehe();
    }
}
