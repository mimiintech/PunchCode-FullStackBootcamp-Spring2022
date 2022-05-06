package com.techelevator.services;


import com.techelevator.model.Puppy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PuppyService {

    private static final String API_BASE_URL = "http://localhost:8080/";
    private RestTemplate restTemplate = new RestTemplate();


    public Puppy[] getAllPuppies() {
        Puppy[] puppies = restTemplate.getForObject(API_BASE_URL + "puppies", Puppy[].class);
        return puppies;
    }

    public Puppy addPuppy(Puppy puppy) {
        HttpEntity<Puppy> entity = makeEntity(puppy);

        Puppy newPuppy = restTemplate.postForObject(API_BASE_URL + "puppy", entity, Puppy.class);

        return newPuppy;
    }

    private HttpEntity<Puppy> makeEntity(Puppy newPuppy) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);  // the body of our request contains JSON

        // wrap the header and the body together in an HttpEntity object
        HttpEntity<Puppy> entity = new HttpEntity<>(newPuppy, headers);

        return entity;

    }
}
