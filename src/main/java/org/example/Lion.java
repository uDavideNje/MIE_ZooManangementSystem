package org.example;

public class Lion extends Animal {
    public Lion(String name) {
        super(name, "Lion");
    }

    @Override
    public void makeNoise() {
        System.out.println("Roar");
    }
}
