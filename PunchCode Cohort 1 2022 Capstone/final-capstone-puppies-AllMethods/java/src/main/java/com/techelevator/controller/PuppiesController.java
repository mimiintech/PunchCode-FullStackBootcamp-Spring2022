package com.techelevator.controller;


import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.techelevator.dao.PuppyDao;
import com.techelevator.model.Puppy;

/**
 * PuppiesController
 */
/**
 * ApiController
 */
@RestController          // identifies the controller a REST api controller - can be called from web service
@RequestMapping("/api")  // Identify root path for all controllers in the - just like it did before
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class PuppiesController {
	
	@Autowired
	PuppyDao thePuppies;
	
	@GetMapping(path= {"/allPuppies", "/"})   // indicates this method with handle HTTP GET requests for the allPuppies
	public List<Puppy> returnPuppyData()  {
		logTimestamp("Getting all puppies");                                    // log time of request	
		List<Puppy> allPuppies = thePuppies.getPuppies();  // Get all puppies from data base
		
		return allPuppies;                                 // return the data requested rather than the view name
	}

	@GetMapping("/puppy/{id}")   // indicates this method with handle HTTP GET requests for the /puppy with id of Puppy to retreive
	public Puppy returnPuppyById(@PathVariable int id) {
    
		logTimestamp("Returning puppy " + id);                              // log time of request	
		
		Puppy aPuppy = thePuppies.getPuppy(id);      // Get the puppie with the supplied id from the database
		
		return aPuppy;                               // return the data requested rather than the view name
	}
	
  @DeleteMapping("/removePuppy/{id}")// indicates this method with handle HTTP Delete requests for the /remove with id of Puppy to retreive
	public void deletePuppy(@PathVariable int id, Principal principal){
		thePuppies.removePuppy(id);
		logTimestamp("Removing puppy " + id + " by user " + principal.getName());
  }
	
	@PostMapping("/savePuppy")// indicates this method with handle HTTP POST requests for the /newPuppy
	public void createPuppy(@RequestBody Puppy newPuppy){
		thePuppies.savePuppy(newPuppy);
		logTimestamp("Creating new puppy" + newPuppy.getName());
	}

  // indicates this method with handle HTTP POST requests for the /newPuppy


	@PutMapping("/editPuppy/{id}")//indicated this method with handle HTTP PUT requests for the /updatePuppy
	public Puppy updatePuppyById(@PathVariable int id, @RequestBody Puppy updatedPuppy){
		logTimestamp("Updating puppy " + id); //Thanks Vellencia
		thePuppies.editPuppy(updatedPuppy, id);
		return returnPuppyById(id);

	}
	
	
	static void logTimestamp(String msg) {    // log timestamp of request to Console
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());	
		System.out.println(msg + " at " + timestamp);
	}
}
