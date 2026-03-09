package org.example;

public class Bird extends Animal{
    public Bird(String name) {
        super(name,"Bird");
    }

    @Override
    public void makeNoise() {
        System.out.println("Chirp");
    }
}
