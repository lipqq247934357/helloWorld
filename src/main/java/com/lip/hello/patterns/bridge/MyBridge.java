package com.lip.hello.patterns.bridge;

public class MyBridge implements Bridge{

    Sourceable sou;

    @Override
    public void setSourceable(Sourceable sou) {
        this.sou = sou;
    }

    @Override
    public Sourceable getSourceable() {
        return sou;
    }
    


    
    
}
