//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.techelevator.services;

import com.techelevator.model.CatCards;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class CatCardService {

    private static final String API_BASE_URL = "http://localhost:8080/api/cards/";
    private static RestTemplate restTemplate = new RestTemplate();

    public static CatCards getCatCardId(long catCardId) {return restTemplate.getForObject(API_BASE_URL + catCardId, CatCards.class);}

    public static CatCards add(CatCards catCards) {
        HttpEntity<CatCards> entity = makeEntity(catCards);

        CatCards returnedCard = null;

        try {
            returnedCard = restTemplate.postForObject(API_BASE_URL, entity, CatCards.class);
        } catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }
        return returnedCard;
    }

    public static boolean update(CatCards updatedCards) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CatCards> entity = makeEntity(updatedCards);

        boolean success = false;

        try {
            restTemplate.put(API_BASE_URL + updatedCards.getCatCardId(), entity);
            success = true;
        } catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }
        return success;
    }

    public static boolean delete(int deleteCatCard) {

        boolean success = false;

        try {
            restTemplate.delete(API_BASE_URL + deleteCatCard);
            success = true;
        } catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }

        return success;
    }

    public static CatCards[] getAllCatCards() {
        CatCards[] catCards = null;

        try {
            catCards = restTemplate.getForObject(API_BASE_URL, CatCards[].class);
        } catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }
        return catCards;
    }

    private static HttpEntity<CatCards> makeEntity(CatCards newCatCards) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);  // the body of our request contains JSON

        // wrap the header and the body together in an HttpEntity object
        HttpEntity<CatCards> entity = new HttpEntity<>(newCatCards, headers);

        return entity;

    }
}
