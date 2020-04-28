package com.project.mockup2html.Services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.project.mockup2html.Models.User;

@Service
public interface UserService {
	
	User findByUsername(String username);
	User findByEmail(String email);
	List<User> findAll();
	User save(@Valid User user);
	User update(@Valid User user);

}