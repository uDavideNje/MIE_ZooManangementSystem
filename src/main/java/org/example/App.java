package org.example;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        ArrayList<Animal> animals = new ArrayList<>();
        int menuChoice=0;
        Scanner kb = new Scanner(System.in);
        System.out.println( "Hello and welcome to the Zoo Management System" );

            do {
                try {
                menu();
                menuChoice = kb.nextInt();
                switch (menuChoice) {
                    case 1:
                        viewAnimals(animals);
                        break;
                    case 2:
                        addAnimal(animals);
                        break;
                    case 3:
                        searchAnimal(animals);
                        break;
                    case 4:
                        System.out.println("Thank you for using our system, goodbye.");
                        break;
                    default:
                        System.out.println("Please select valid option");
                }
            }catch (InputMismatchException inputMismatchException){
                System.out.println("You've entered an invalid input, try again");
                kb.next();
            }
            } while (menuChoice != 4);


    }

    private static void searchAnimal(ArrayList<Animal> animals) {
        Scanner kb = new Scanner(System.in);
        System.out.println("enter animal name:");
        String animalName = kb.next();
        System.out.println("enter animal species:"+
                "\n 1. Lion" +
                "\n 2. Elephant" +
                "\n 3. Bird");
        int animalChoice = kb.nextInt();
        String animalSpecies = switch(animalChoice){
            case 1 -> "Lion";
            case 2 -> "Elephant";
            case 3 -> "Bird";
            default -> "invald";
        };
        for(int i = 0; i <animals.size(); i++){
            if(animals.get(i).getName().contains(animalName) && animals.get(i).getSpecies().contains(animalSpecies)){
                animals.get(i).makeNoise();
            }else{
                System.out.println("Animal not found");
            }
        }
//        Animal find = new Animal(animalName,animalSpecies);
//        int index = animals.indexOf(find);
//        System.out.println(animalName);
//        System.out.println(animalSpecies);
//        System.out.println(index);
//        if (index>-1) {
//            Animal animal = animals.get(index);
//            animal.makeNoise();
//        }
    }

    private static void viewAnimals(ArrayList<Animal> animals) {
        System.out.println("Animal List");
        System.out.println("------");
        for (Animal animal : animals) {
            animal.animalInfo();
        }
    }

    public static void menu(){
        System.out.println("1. View Animals\n" +
                            "2. Add Animal\n" +
                            "3. Search Animal \n"+
                            "4. Exit");
    }

    public static void addAnimal(ArrayList<Animal> animals){
        Scanner kb = new Scanner(System.in);
        int species;
        String name;
        System.out.println("Enter animal species: " +
                "\n 1. Lion" +
                "\n 2. Elephant" +
                "\n 3. Bird");
        species = kb.nextInt();
        System.out.println("Enter animal name: ");
        name = kb.next();

        switch (species){
            case 1: animals.add(new Lion(name));
            break;
            case 2: animals.add(new Elephant(name));
            break;
            case 3: animals.add(new Bird(name));
        }


    }
}
