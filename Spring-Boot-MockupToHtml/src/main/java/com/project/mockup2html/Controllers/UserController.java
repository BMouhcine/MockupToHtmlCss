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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.mockup2html.Models.User;
import com.project.mockup2html.Services.UserService;


@RestController

@RequestMapping("/")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	public static long currentUserId=-1;
	private final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
    private UserService userDao;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	
	
	// Register Handler
	@PostMapping("/createUser")
    ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        log.info("Request to create user: {}", user);
        User userFound = userDao.findByUsername(user.getUsername());
        User userEmailFound = userDao.findByEmail(user.getEmail());
        if(userFound!=null || userEmailFound!=null)
        	return ResponseEntity.badRequest().body("username or email already exists");
        user.setEnabled(true);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User result = userDao.save(user);
        return ResponseEntity.ok().body(null);
    }
	
	// Update User Handler
	@PostMapping("/editUser")
    ResponseEntity editUser(@RequestParam String username,@RequestParam String newPwd, @RequestParam String oldPwd) {
        log.info("Request to update user: {}", username);
        User userFound = userDao.findByUsername(username);
        if(new BCryptPasswordEncoder().matches(oldPwd, userFound.getPassword())) {
        	userFound.setPassword(bCryptPasswordEncoder.encode(newPwd));
        	userDao.save(userFound);
        	return ResponseEntity.ok().body("Creds updated successfully.");
        }else {
        	return ResponseEntity.ok().body("Old password is wrong.");
        }
    }
	
	// USER CREDS CHECKER
	
     	@PostMapping("/login")
	    ResponseEntity<User> checkUser(@Valid @RequestBody User user) {
     		System.out.println("mhzg");
	        User userFound = userDao.findByUsername(user.getUsername());
	        if(userFound!=null) {
		        if(bCryptPasswordEncoder.matches(user.getPassword(), userFound.getPassword())) {
		        	currentUserId = userFound.getId_user();
		        	return ResponseEntity.ok().body(userFound);
		        }
	        }
	        return ResponseEntity.ok().body(null);
	    }
	
	
	
	
	
	
	
	
	
}
