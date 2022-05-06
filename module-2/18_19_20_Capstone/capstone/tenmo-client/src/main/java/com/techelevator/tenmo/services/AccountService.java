package com.techelevator.tenmo.services;

import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.UserCredentials;

import java.math.BigDecimal;

public class AccountService extends AuthenticatedApiService{

    private final String baseURL;

    public AccountService(String baseURL){
    this.baseURL = baseURL + "account/";
}
//    public getBalance(){
//    BigDecimal balance = null;
//    try{
//        ResponseEntity<BigDecimal> response = restTemplate.exchange()
//    } catch (RestClientResponseException | ResourceAccessException e){
//        Basic
//    }
//
//    }


}
