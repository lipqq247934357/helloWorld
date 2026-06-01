package com.lip.hello.patterns.singleton;

public class LazyType {

    private static LazyType lazyType;

    private LazyType() {

    }

    public static LazyType getInstance() {

        if(lazyType==null){
            synchronized(lazyType){
                lazyType = new LazyType();     
            }
        }
        return lazyType;
    }
}
