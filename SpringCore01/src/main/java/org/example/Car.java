package org.example;

public class Car {

    Engine engine;

    public Car() {}
    public Car(Engine engine) {
        System.out.println("Car Constructor");
        this.engine = engine;
    }

    public Engine getEngine() {

         return engine;
    }

    public void setEngine(Engine engine) {
        System.out.println("Car set engine");
        this.engine = engine;
    }

    public void drive(){
        int start= engine.start();
        if(start>0){
            System.out.println("Car engine started");
        }
        else{
            System.out.println("Car engine not started");
        }
    }
}
