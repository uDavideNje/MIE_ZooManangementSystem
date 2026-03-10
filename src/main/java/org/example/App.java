package org.example;


import org.sdf.InputError;

import java.util.*;

public class App
{
    public static void main( String[] args )
    {
        Random rand = new Random();
        ArrayList<Animal> animals = new ArrayList<>();
        int menuChoice=0;
        String[] name = {"james", "john", "leo", "micheal", "liam"};
        for(int i = 0; i<6; i++){
            int spec = rand.nextInt(2);
            Animal animal ;
            animal = switch (spec){
                case 1 -> new Elephant(name[rand.nextInt(name.length-1)]);
                case 2 -> new Bird(name[rand.nextInt(name.length-1)]);
                default -> new Lion(name[rand.nextInt(name.length-1)]);
            };

            animals.add(animal);
        }

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
            } catch (InputError e) {
                    System.out.println("Input must be form 1 to 3");
                }
            } while (menuChoice != 4);


    }

    private static void searchAnimal(ArrayList<Animal> animals) throws InputError {
        Scanner kb = new Scanner(System.in);
        System.out.println("Pick search type: \n" +
                "1. Search by name and species \n" +
                "2. Search by name ");
        int typeSearch = kb.nextInt();
        switch (typeSearch){
            case 1: nameAndSpeciesSearch(animals);
            break;
            case 2: searchByName(animals);
            break;
            default:
                System.out.println(" you've entered an invalid option");
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
    public static void inputCheck  (int input) throws InputError {
            if(input>3 || input<1){
                throw new InputError();
            }
    }
    private static void viewAnimals(ArrayList<Animal> animals) {
        StringBuilder listBld = new StringBuilder("Animal List \n ------------");
        for (Animal animal : animals) {
            listBld.append(animal.animalInfo());
         }
        System.out.println(listBld);
    }

    public static void menu(){
        System.out.println("1. View Animals\n" +
                            "2. Add Animal\n" +
                            "3. Search Animal \n"+
                            "4. Exit");
    }

    public static void addAnimal(ArrayList<Animal> animals) throws InputError {
        Scanner kb = new Scanner(System.in);
        int species;
        String name;
        System.out.println("Enter animal species: " +
                "\n 1. Lion" +
                "\n 2. Elephant" +
                "\n 3. Bird");
        species = kb.nextInt();
        inputCheck(species);
        System.out.println("Enter animal name: ");
        name = kb.next().toLowerCase();

        switch (species){
            case 1: animals.add(new Lion(name));
            break;
            case 2: animals.add(new Elephant(name));
            break;
            case 3: animals.add(new Bird(name));
        }
    }

    public static void nameAndSpeciesSearch(ArrayList<Animal> animals) throws InputError {
        Scanner kb = new Scanner(System.in);
        System.out.println("enter animal name:");
        String animalName = kb.next().toLowerCase();
        int cnt =0;
        System.out.println("enter animal species:"+
                "\n 1. Lion" +
                "\n 2. Elephant" +
                "\n 3. Bird");
        int animalChoice = kb.nextInt();
        inputCheck(animalChoice);
        String animalSpecies = switch(animalChoice){
            case 1 -> "Lion";
            case 2 -> "Elephant";
            case 3 -> "Bird";
            default -> "invald";
        };
        for(int i = 0; i <animals.size(); i++){
            if(animals.get(i).getName().contains(animalName) && animals.get(i).getSpecies().contains(animalSpecies)){
                animals.get(i).animalInfo();
                animals.get(i).makeNoise();
                cnt++;
            }
        }
        if(cnt>0){
            System.out.println("There were "+ cnt + " " +animalSpecies +"s with the name " +animalName + " found."  );
        }else{
            System.out.println("There were no " +animalSpecies +"s with the name " +animalName + " found."  );
        }
    }

    public static void searchByName(ArrayList<Animal> animals){
        int cnt =0;
        Scanner kb = new Scanner(System.in);
        System.out.println("enter animal name:");
        String animalName = kb.next().toLowerCase();
        for(int i= 0; i < animals.size(); i++){
            if(animals.get(i).getName().contains(animalName)){
                animals.get(i).animalInfo();
                animals.get(i).makeNoise();
                cnt++;

            }

        }
        System.out.println("There were "+ cnt + " animals with the name " +animalName + " found."  );
    }

}
