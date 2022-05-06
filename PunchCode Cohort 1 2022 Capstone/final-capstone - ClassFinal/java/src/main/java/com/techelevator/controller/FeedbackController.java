package com.techelevator.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.techelevator.dao.FeedbackDao;
import com.techelevator.model.Feedback;

//ApiController
//this controller will receive incoming web requests and will know what model or method to call to retrieve/manipulate data requested by the view/application
//use @ResponseStatus to return specific successful status code that corresponds to a specific method instead of default 200
//for example @ResponseStatus(HttpStatus.NO_CONTENT) will display status code 204 for a successful DELETE request
//instead of multiple @RequestParam, @RequestBody is used to have the incoming request body read and deserialized into a java object

@RestController          // identifies the controller a REST api controller - can be called from web service
@RequestMapping("/api")  // Identify root path for all controllers in the - just like it did before
@CrossOrigin
//@PreAuthorize("isAuthenticated()")

public class FeedbackController {
    @Autowired
    FeedbackDao theFeedback; //theProduct is injected by Spring in response to ProductsController being created using @Autowired - eliminates need for getters & setters

    @GetMapping(path= {"/allFeedback", "/"})   // indicates this method with handle HTTP GET requests for the allForum

    public List<Feedback> getAllFeedback()  {
        logTimestamp("Getting all feedback");                                    // log time of request
        List<Feedback> allFeedback = theFeedback.getAllAnswers();  // Get all products from db

        return allFeedback;                                 // return the data requested rather than the view name
    }

    @GetMapping("/feedback/{id}")   // indicates this method with handle HTTP GET requests for the /product with id of product to retreive
    public Feedback getFeedbackById(@PathVariable int id) {

        logTimestamp("Returning feedback" + id);                              // log time of request

        Feedback feedback = theFeedback.getAnswer(id);      // Get the product with the supplied id from the db

        return feedback;                               // return the data requested rather than the view name
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteAnswer/{id}")// indicates this method with handle HTTP Delete requests for the /deleteProduct with id of product to retreive
    public void deleteFeedbackById(@RequestBody Feedback answerToDelete){
        logTimestamp("Removing answer" + answerToDelete.getAnswer());
        theFeedback.deleteAnswer(answerToDelete);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addAnswer")// indicates this method with handle HTTP POST requests for the /addProduct
    public void addNewAnswer(@PathVariable int forumId, int userId, @RequestBody Feedback answerToAdd){
        logTimestamp("Creating new answer" + answerToAdd.getAnswer());
        theFeedback.createAnswer(forumId, userId, answerToAdd);
    }


    @PutMapping("/updateAnswer/{id}")//indicated this method with handle HTTP PUT requests for the /updateProduct
    public void updateAnswerById(@PathVariable int id, @RequestBody Feedback answerToUpdate) {
        logTimestamp("Updating answer" + id);
        theFeedback.updateAnswer(id, answerToUpdate);
    }


    static void logTimestamp(String msg) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(msg + " at " + timestamp);
    }




}
