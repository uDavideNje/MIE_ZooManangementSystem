package org.example;

public class Animal {
    private String name;
    private  String species;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public void animalInfo(){
        System.out.println("Name of animal: " +name);
        System.out.println("Species of name: " +species);
    }

    public void makeNoise(){
        System.out.println("animal noise");
    }

}
