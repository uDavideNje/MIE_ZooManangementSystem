package org.example;

public class Elephant extends Animal{
    public Elephant(String name) {
        super(name,"Elephant");
    }

    @Override
    public void makeNoise() {
        System.out.println("Trumpet");
    }
}
