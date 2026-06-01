package com.lip.hello.patterns.singleton;

public class HungryType {

    private static HungryType hungryType = new HungryType();
    
    private HungryType(){
        
    }
    
    public static HungryType getInstance(){
        return hungryType;
    }
}
