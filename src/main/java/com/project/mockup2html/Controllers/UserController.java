package com.project.mockup2html.Controllers;

import java.util.Collection;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.mockup2html.Dao.UserDao;
import com.project.mockup2html.Models.User;



@RestController
@RequestMapping("/")
public class UserController {
	public static long currentUserId=-1;
	private final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
    private UserDao userDao;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserController(UserDao userDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDao = userDao;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
    @GetMapping("/users")
    Collection<User> users() {
    	System.out.println("Method executed with results: ");
    	userDao.findAll().forEach(System.out::println);
        return (Collection<User>) userDao.findAll();
    }
  
    @PostMapping("/user")
    ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        log.info("Request to create user: {}", user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User result = userDao.save(user);
        return ResponseEntity.ok().body(result);
    }
    
    @PutMapping("/user/{id}")
    ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
        log.info("Request to update user: {}", user);
        User result = userDao.save(user);
        return ResponseEntity.ok().body(result);
    }

}