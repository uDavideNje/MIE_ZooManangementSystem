package org.example;

public class Animal {
    private String name;
    private  String species;
    private StringBuilder nameStrBld = new StringBuilder("Name of animal: ");
    private StringBuilder speciesStrBld = new StringBuilder("Species of name: ");

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
        System.out.println( nameStrBld.append(name));
        System.out.println( speciesStrBld.append(species));
    }

    public void makeNoise(){
        System.out.println("animal noise");
    }

}
