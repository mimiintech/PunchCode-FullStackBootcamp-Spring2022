package com.techelevator.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.techelevator.dao.ForumDao;
import com.techelevator.model.Forum;

//ApiController
//this controller will receive incoming web requests and will know what model or method to call to retrieve/manipulate data requested by the view/application
//use @ResponseStatus to return specific successful status code that corresponds to a specific method instead of default 200
//for example @ResponseStatus(HttpStatus.NO_CONTENT) will display status code 204 for a successful DELETE request
//instead of multiple @RequestParam, @RequestBody is used to have the incoming request body read and deserialized into a java object

@RestController          // identifies the controller a REST api controller - can be called from web service
@RequestMapping("/api")  // Identify root path for all controllers in the - just like it did before
@CrossOrigin
//@PreAuthorize("isAuthenticated()")

public class ForumController {
    @Autowired
    ForumDao theForum; //theProduct is injected by Spring in response to ProductsController being created using @Autowired - eliminates need for getters & setters

    @GetMapping(path= {"/allForum", "/"})   // indicates this method with handle HTTP GET requests for the allForum

    public List<Forum> getAllForums()  {
        logTimestamp("Getting all products");                                    // log time of request
        List<Forum> allForums = theForum.getAllQuestions();  // Get all products from db

        return allForums;                                 // return the data requested rather than the view name
    }

    @GetMapping("/forum/{id}")   // indicates this method with handle HTTP GET requests for the /product with id of product to retreive
    public Forum getProductById(@PathVariable int id) {

        logTimestamp("Returning forum " + id);                              // log time of request

        Forum forum = theForum.getQuestion(id);      // Get the product with the supplied id from the db

        return forum;                               // return the data requested rather than the view name
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteQuestion/{id}")// indicates this method with handle HTTP Delete requests for the /deleteProduct with id of product to retreive
    public void deleteProductById(@PathVariable int id, @RequestBody Forum questionToDelete){
        logTimestamp("Removing question" + questionToDelete.getQuestion());
        theForum.deleteQuestion(id, questionToDelete);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addQuestion")// indicates this method with handle HTTP POST requests for the /addProduct
    public void addNewQuestion(@RequestBody Forum questionToAdd){
        logTimestamp("Creating new product" + questionToAdd.getQuestion());
        theForum.createQuestion(questionToAdd);
    }


    @PutMapping("/updateQuestion/{id}")//indicated this method with handle HTTP PUT requests for the /updateProduct
    public void updateQuestionById(@PathVariable int id, @RequestBody Forum questionToUpdate) {
        logTimestamp("Updating product " + id);
        theForum.updateQuestion(id, questionToUpdate);
    }


    static void logTimestamp(String msg) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(msg + " at " + timestamp);
    }




}
