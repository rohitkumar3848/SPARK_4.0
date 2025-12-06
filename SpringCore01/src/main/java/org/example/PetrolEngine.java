package org.example;

public class PetrolEngine implements Engine {
    public PetrolEngine(){
        System.out.println("PetrolEngine constructor");
    }
    @Override
    public int start() {
        System.out.println("PetrolEngine start");
        return 1;
    }
}
