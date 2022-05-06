package com.techelevator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FeedbackNotFoundException extends RuntimeException{
    public FeedbackNotFoundException() { super("Feedback Not Found");}
}
