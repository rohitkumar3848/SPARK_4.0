package org.example;

public class DieselEngine implements Engine{
    public DieselEngine(){
        System.out.println("DieselEngine constructor");
    }
    @Override
    public int start() {
        System.out.println("DieselEngine started");
        return 1;
    }
}
