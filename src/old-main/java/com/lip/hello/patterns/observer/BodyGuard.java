package com.lip.hello.patterns.observer;

public class BodyGuard implements Observer{

    @Override
    public void act() {
        System.out.println("bodyGuard go!");
    }

}
