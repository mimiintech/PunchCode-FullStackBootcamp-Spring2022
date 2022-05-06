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

public class TransferService extends AuthenticatedApiService{


//    public boolean sendBucks(int fromId, int toId, Transfer transfer) throws TransferServiceException {
//        HttpEntity<UserCredentials> entity = createCredentialsEntity(credentials);
//
//        boolean hasSent = false;
//        try {
//            hasSent = restTemplate
//                    .exchange(BASE_URL +
//                                    "/transfers/send/" + fromId + "/" + toId,
//                            HttpMethod.POST,
//                            makeTransferEntity(transfer),
//                            Boolean.class)
//                    .getBody();
//        } catch(RestClientResponseException ex) {
//            throw new TransferServiceException(ex.getRawStatusCode() + " : " + ex.getResponseBodyAsString());
//        }
//        return hasSent;
    }
    
