package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
 @RequestMapping("/demo")
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	// Add new user
	  @PostMapping(path="/add") // Map ONLY POST Requests 
	  public @ResponseBody String addNewUser (@RequestBody User user) {
			repo.save(user);
			return "Saved";
	  }
	 
	  // Get individual id
	  @GetMapping(path="/all/{id}")
	  public Optional<User> getUser(@PathVariable("id") int id) {
		 return repo.findById(id);
		}
	  
	  //Get All users
	  @GetMapping(path="/all")
	  public @ResponseBody Iterable<User> getAllUsers() {
	    return repo.findAll();
	  }
	  
	  //Update user
	  @PutMapping("/all")
	  private User update(@RequestBody User user,int id) {
		  repo.save(user);
		  return user;
	  }
	  
	  //Delete all users
		
		  @DeleteMapping("/all") 
		  private void deleteUsers() {
		  
		  repo.deleteAll();
		  
		  }
		 
	  //Delete individual user
	  @DeleteMapping("/all/{id}")
	  private void deleteUser(@PathVariable int id) {
		  repo.deleteById(id);
		  
	  }
}
