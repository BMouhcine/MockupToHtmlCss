package com.project.mockup2html.Controllers;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.mockup2html.Models.User;
import com.project.mockup2html.Repositories.UserRepository;
import com.project.mockup2html.Services.UserService;


@RestController

@RequestMapping("/")
@CrossOrigin("*")
public class UserController {
	public static long currentUserId=-1;
	private final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
    private UserService userDao;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	UserRepository userRepository;
	
	
	
	
	// Register Handler
	@PostMapping("/createUser")
    ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        log.info("Request to create user: {}", user);
        User userFound = userDao.findByUsername(user.getUsername());
        User userEmailFound = userDao.findByEmail(user.getEmail());
        if(userFound!=null || userEmailFound!=null)
        	return ResponseEntity.badRequest().body("username or email already exists");
        //user.setEnabled(true);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User result = userDao.save(user);
        return ResponseEntity.ok().body(null);
    }
	
	// Update User Handler
	@PostMapping("/editUser")
    ResponseEntity editUser(@RequestHeader("newPassword") String newPassword, @RequestHeader("lastpassword") String lastpassword) {
		if(currentUserId!=-1) {
	        
	        User userBuffer = userRepository.findById(UserController.currentUserId).get();
	        log.info("Request to update user: {}", userBuffer.getUsername());
	        if(new BCryptPasswordEncoder().matches(lastpassword, userBuffer.getPassword())) {
	        	userBuffer.setPassword(bCryptPasswordEncoder.encode(newPassword));
	        	userDao.save(userBuffer);
	        	return ResponseEntity.ok().body(null);
	        }else {
	        	return ResponseEntity.ok().body("Old password is wrong.");
	        }
	        
		}return ResponseEntity.ok().body("NOT CONNECTED");

    }
	
	// USER CREDS CHECKER
	
     	@PostMapping("/login")
	    ResponseEntity<String> checkUser(@RequestBody User user) {
     		System.out.println("mhzg");
	        User userFound = userDao.findByUsername(user.getUsername());
	        if(userFound!=null) {
		        if(bCryptPasswordEncoder.matches(user.getPassword(), userFound.getPassword())) {
		        	currentUserId = userFound.getId_user();
		        	return ResponseEntity.ok().body(null);
		        }
	        }
	        return ResponseEntity.ok().body(null);
	    }
     	
     	
	
	
	
	
	
	
	
	
}
