package com.techelevator.view;

import com.techelevator.dao.FilePuppyDao;
import com.techelevator.dao.JdbcPuppyDao;
import com.techelevator.dao.PuppyDao;
import com.techelevator.model.Puppy;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class FilFosterApplication {

    private PuppyDao dao;

    public FilFosterApplication(BasicDataSource datasource){
        dao = new JdbcPuppyDao(datasource);
    }

    public FilFosterApplication(){
        dao = new FilePuppyDao("puppyFile.txt");
    }

    public static void main(String[] args) {
        BasicDataSource datasource = new BasicDataSource();
        datasource.setUrl("jdbc:postgresql://localhost:5432/puppydb");
        datasource.setUsername("postgres");
        datasource.setPassword("postgres1");
        FilFosterApplication app = new FilFosterApplication(datasource);

//        FilFosterApplication app = new FilFosterApplication();
        app.run();
    }

    public void run(){
        List<Puppy> puppies = dao.getAllPuppies();

        for (Puppy pup: puppies){
            System.out.println(pup.getPuppyId() + " " + pup.getPuppyName());  // pup it defaults to pup.toString()
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the puppy you want to see all information on>> ");
        int id = Integer.parseInt(scanner.nextLine());

        Puppy puppy = dao.getPuppyById(id);
        if (puppy != null) {
            System.out.println(puppy);
        } else {
            System.out.println("Pupper not found!!");
        }
        Puppy newPuppy = new Puppy("Mr. Toad", 27, "male",
                "Pug", true);
         Puppy retrievedPuppy = dao.savePuppy(newPuppy);
        System.out.println(retrievedPuppy.getPuppyName() +
                " was written to the data source!");
    }
}
