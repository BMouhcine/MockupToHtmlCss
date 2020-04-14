package com.project.mockup2html.Dao;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.project.mockup2html.Models.User;


@Service
public interface UserDao {
	User findByUsername(String username);
	User findByEmail(String email);
	Collection<User> findAll();
	User save(@Valid User user);

}