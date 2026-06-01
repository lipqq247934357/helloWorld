package com.lip.hello.patterns.abstractfactory;

public class SendVegetable implements Send{

    @Override
    public Food sendFood() {
        
        return new Vegetable();
    }

}
