package com.techelevator.view;

import com.techelevator.model.CatCards;
import com.techelevator.services.CatCardService;

import java.util.Scanner;

public class CatCardCLI {

    private final CatCardService cardService = new CatCardService();

    public static void main(String[] args) {
        CatCardCLI app = new CatCardCLI();
        app.run();
    }

    public void run() {

        System.out.println("Welcome to your Cat Card App!");

        System.out.println("Here is our Cat Card collection: ");

        CatCards[] catCards = CatCardService.getAllCatCards();

        System.out.println();
        for (CatCards cat : catCards) {
            System.out.println("Cat Card Id: " + cat.getCatCardId() + "\n" + "Name: " + cat.getName() + "\n" + "Cat Fact: " + cat.getCatFact()
                    + "\n" + "Image Url: " + cat.getImgUrl() + "\n" + "Caption: " + cat.getCaption() + "\n" + "\n" + "*****" + "\n");
        }

        System.out.println("---End of Collection---");
        System.out.println("Make a Selection: ");
        System.out.println("1. Add a Cat Card");
        System.out.println("2. Update a Cat Card by ID");
        System.out.println("3. Delete a Cat Card by ID");
        System.out.println("4. Display a Cat Card Collection");
        System.out.println("5. End Program");
        System.out.println();

           Scanner input = new Scanner(System.in);
           String option = input.nextLine();
           if (option.equalsIgnoreCase("1")) {
               addFunction();
           } else if (option.equalsIgnoreCase("2")) {
               updateFunction();
           } else if (option.equalsIgnoreCase("3")) {
               deleteFunction();
           } else if (option.equalsIgnoreCase("4")) {
                allFunction();
           } else if (option.equalsIgnoreCase("5")) {
               System.out.println("Thanks for using the App!");
           }
    }

    private void addFunction() {

        Scanner input = new Scanner(System.in);
        System.out.println("Add a new Cat Card!");
        System.out.println("Enter name: ");
        String name = input.nextLine();
        System.out.println("Enter image URL: ");
        String url = input.nextLine();
        System.out.print("Enter cat fact: ");
        String fact = input.nextLine();
        System.out.print("Enter caption: ");
        String caption = input.nextLine();

        CatCards newCard = new CatCards();
        newCard.setName(name);
        newCard.setImgUrl(url);
        newCard.setCatFact(fact);
        newCard.setCaption(caption);

        CatCards addedCard = CatCardService.add(newCard);
        System.out.println("Cat Card Added! ");
    }

    private void updateFunction() {

        Scanner option = new Scanner(System.in);
        System.out.println("Enter Cat Card ID to update: \n");
        long catCardId = Long.parseLong(option.nextLine());

        Scanner input = new Scanner(System.in);
        System.out.println("What card item would you like to update");
        System.out.println("\n 1. Name\n 2. Fact \n 3. Image \n 4. Caption");
        String updateOption = input.nextLine();

//        Name
        if (updateOption.equalsIgnoreCase("1")) {
            System.out.println("Enter New Name");
            String newName = input.nextLine();
            CatCards existingCat = CatCardService.getCatCardId(catCardId);
            existingCat.setName(newName);
            CatCardService.update(existingCat);
            System.out.println("ID:" + existingCat.getCatCardId() + "\nName:" + existingCat.getName() + "\n"
                    + "Fun Fact: " + existingCat.getCatFact() + "\n" + "Image URL: " + existingCat.getImgUrl() + "\n" + "Caption: "
                    + existingCat.getCaption() + "\n");
        }

//        Fact
        else if (updateOption.equalsIgnoreCase("2")) {
            System.out.println("Enter a New Fact");
            String newFact = input.nextLine();
            CatCards existingFact = CatCardService.getCatCardId(catCardId);
            existingFact.setCatFact(newFact);
            CatCardService.update(existingFact);
            System.out.println("ID:" + existingFact.getCatCardId() + "\nName:" + existingFact.getName() + "\n"
                    + "Fun Fact: " + existingFact.getCatFact() + "\n" + "Image URL: " + existingFact.getImgUrl() + "\n" + "Caption: "
                    + existingFact.getCaption() + "\n");
        }
//
//        Image
       else  if (updateOption.equalsIgnoreCase("3")) {
            System.out.println("Enter a New Url");
            String newImage = input.nextLine();
            CatCards existingImage = CatCardService.getCatCardId(catCardId);
            existingImage.setImgUrl(newImage);
            CatCardService.update(existingImage);
            System.out.println("ID:" + existingImage.getCatCardId() + "\nName:" + existingImage.getName() + "\n"
                    + "Fun Fact: " + existingImage.getCatFact() + "\n" + "Image URL: " + existingImage.getImgUrl() + "\n" + "Caption: "
                    + existingImage.getCaption() + "\n");
        }

//        Caption
        else if (updateOption.equalsIgnoreCase("4")) {
            System.out.println("Enter a New Caption");
            String newCaption = input.nextLine();
            CatCards existingCaption = CatCardService.getCatCardId(catCardId);
            existingCaption.setCaption(newCaption);
            System.out.println("ID:" + existingCaption.getCatCardId() + "\nName:" + existingCaption.getName() + "\n"
                    + "Fun Fact: " + existingCaption.getCatFact() + "\n" + "Image URL: " + existingCaption.getImgUrl() + "\n" + "Caption: "
                    + existingCaption.getCaption() + "\n");
        }

    }

    private void deleteFunction() {
        Scanner deleteInput = new Scanner(System.in);
        System.out.println("Enter Cat Card ID: ");
        int id = Integer.parseInt(deleteInput.nextLine());
        CatCardService.delete(id);
        System.out.println("Cat Card deleted!");
    }

    private void allFunction() {

        System.out.println("Here is our Cat Card collection: ");

        CatCards[] catCards = CatCardService.getAllCatCards();

        System.out.println();
        for (CatCards cat : catCards) {
            System.out.println("Cat Card Id: " + cat.getCatCardId() + "\n" + "Name: " + cat.getName() + "\n" + "Cat Fact: " + cat.getCatFact()
                    + "\n" + "Image Url: " + cat.getImgUrl() + "\n" + "Caption: " + cat.getCaption() + "\n" + "\n" + "*****" + "\n");
        }
    }
}











