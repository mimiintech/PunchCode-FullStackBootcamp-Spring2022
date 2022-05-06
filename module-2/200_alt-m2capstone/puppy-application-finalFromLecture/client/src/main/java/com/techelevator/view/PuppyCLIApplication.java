package com.techelevator.view;

import com.techelevator.model.Puppy;
import com.techelevator.services.PuppyService;

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
    }
}
