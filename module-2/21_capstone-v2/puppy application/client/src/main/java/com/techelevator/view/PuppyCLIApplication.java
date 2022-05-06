package com.techelevator.view;

import com.techelevator.model.Puppy;
import com.techelevator.services.PuppyService;

import java.util.Scanner;

public class PuppyCLIApplication {

    private final PuppyService puppyService = new PuppyService();

    public static void main(String[] args) {
        PuppyCLIApplication app = new PuppyCLIApplication();
        app.run();
    }

    public void run(){
        System.out.println("Welcome to our RESTful API Puppy Application!");

        System.out.println("Here is a list of all our puppies: ");

        Puppy[] puppies = puppyService.getAllPuppies();

        for (Puppy pup: puppies){
            System.out.println(pup.getPuppyId()+" "  + String.format("%-20s", pup.getPuppyName()) + "  Breed: " + pup.getBreed() );

        }

        System.out.println("Add a new puppy!");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter weight: ");
        int weight = Integer.parseInt(input.nextLine());
        System.out.print("Enter sex: ");
        String sex = input.nextLine();
        System.out.print("Enter breed: ");
        String breed = input.nextLine();
        System.out.print("Paper Trained? (Y/N): ");
        boolean paperTrained = false;
        if ( input.nextLine().equalsIgnoreCase("y")){
            paperTrained = true;
        }
        System.out.print("Enter fact: ");
        String fact = input.nextLine();

        Puppy newPup = new Puppy();
        newPup.setPuppyName(name);
        newPup.setWeight(weight);
        newPup.setSex(sex);
        newPup.setBreed(breed);
        newPup.setPaperTrained(paperTrained);
        newPup.setFact(fact);

        Puppy addedPup = puppyService.addPuppy(newPup);
        System.out.println("Puppy Added! " + addedPup.getFact());

    }
}
