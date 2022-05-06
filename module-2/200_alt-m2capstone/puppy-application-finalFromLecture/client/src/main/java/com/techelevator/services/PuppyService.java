package com.techelevator.services;


import com.techelevator.model.Puppy;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PuppyService {

    private static final String API_BASE_URL = "http://localhost:8080/";
    private RestTemplate restTemplate = new RestTemplate();


    public Puppy[] getAllPuppies(){
        Puppy[] puppies = restTemplate.getForObject(API_BASE_URL + "puppies", Puppy[].class);
        return puppies;
    }

}
