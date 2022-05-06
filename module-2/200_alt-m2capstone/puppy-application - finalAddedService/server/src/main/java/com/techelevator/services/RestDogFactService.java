package com.techelevator.services;

import com.techelevator.model.DogFact;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestDogFactService implements DogFactService{

    private static final String API_URL = "https://dog-facts-api.herokuapp.com/api/v1/resources/dogs";
    private RestTemplate restTemplate = new RestTemplate();



    @Override
    public DogFact getRandomDogFact() {
        int randomNum = (int) (Math.random() * 495 + 1);
        DogFact[] list = restTemplate.getForObject(API_URL + "?index=" + randomNum, DogFact[].class);
        return list[0];
    }
}
