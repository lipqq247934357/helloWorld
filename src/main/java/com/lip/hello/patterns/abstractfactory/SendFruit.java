package com.lip.hello.patterns.abstractfactory;

public class SendFruit implements Send {

    @Override
    public Food sendFood() {
        return new Fruit();
    }

}
