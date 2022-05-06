package com.techelevator.controller;

import com.techelevator.dao.PuppyDao;
import com.techelevator.model.Puppy;
import com.techelevator.services.DogFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PuppyController {

    @Autowired
    private PuppyDao dao;  // @autowired lets SpringBoot be in charge of wiring our dao for us

    @Autowired
    private DogFactService service;
    /**
     * return all puppies
     */
    @RequestMapping(path="/puppies", method = RequestMethod.GET)
    public List<Puppy>  getAllPuppies() {
        List<Puppy> puppyList = dao.getAllPuppies();
        return puppyList;
    }

    /**
     * Add a puppy
     *
     * @param puppy object
     * @return puppy object
     */
    @RequestMapping(path="/puppy", method = RequestMethod.POST)
    public Puppy addPuppy(@RequestBody Puppy puppy){
        String fact = service.getRandomDogFact().getFact();
        puppy.setFact(fact);
        return dao.savePuppy(puppy);
    }

    /**
     * Get a puppy by id
     */

    /**
     * Get a puppy by name
     */

    /**
     * Update a puppy
     */

    /**
     * Delete a puppy
     */




}
