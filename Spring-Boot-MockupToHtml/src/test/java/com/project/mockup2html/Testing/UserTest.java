package com.project.mockup2html.Testing;

import java.util.List;

import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.mockup2html.Models.User;
import com.project.mockup2html.Repositories.UserRepository;
@Stateless
public class UserTest {
	
	  @Autowired
	  UserRepository userRepository;
	  
	  public User createUser(User user) { return userRepository.save(user); }
	  public List<User> findAll() { return userRepository.findAll(); } 
	  public void deleteUser(User user) { userRepository.delete(user); }
	  
}
