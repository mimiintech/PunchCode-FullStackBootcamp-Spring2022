package com.techelevator.dao;

import com.techelevator.model.Puppy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilePuppyDao implements  PuppyDao{

    private File file;
    private Scanner input;

    public FilePuppyDao(String fileName){
        file = new File(fileName);
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Puppy> getAllPuppies() {
        List<Puppy>  puppyList = new ArrayList<>();
        while (input.hasNext()){
            String line = input.nextLine();
            String [] lineArr = line.split(",");
            //4,Pawla,50,female,Boxer,false
            Puppy puppy = new Puppy(Integer.parseInt(lineArr[0]),
                    lineArr[1],
                    Integer.parseInt(lineArr[2]),
                    lineArr[3],
                    lineArr[4],
                    Boolean.parseBoolean(lineArr[5]));
            puppyList.add(puppy);

        }
        return puppyList;
    }

    @Override
    public Puppy getPuppyById(int puppyId) {
        return null;
    }

    @Override
    public Puppy savePuppy(Puppy puppy) {
        return null;
    }

    @Override
    public Puppy updatePuppy(Puppy puppy) {
        return null;
    }

    @Override
    public void removePuppy(int puppyId) {

    }
}
