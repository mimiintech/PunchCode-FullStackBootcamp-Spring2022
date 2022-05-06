package com.techelevator.dao;

import com.techelevator.model.Puppy;

import java.util.List;

public interface PuppyDao {

    //   CRUD!!!
    // get all puppies back
    List<Puppy> getAllPuppies();

    // get one puppy by id
    Puppy getPuppyById(int puppyId);

    // insert a puppy into the data source
    Puppy savePuppy(Puppy puppy);

    // update puppy information
    Puppy updatePuppy(Puppy puppy);

    // remove puppy from data source
    void removePuppy(int puppyId);
}
