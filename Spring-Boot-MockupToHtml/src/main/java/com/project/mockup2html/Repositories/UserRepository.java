package com.project.mockup2html.Repositories;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.mockup2html.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	User findByEmail(String email);
	List<User> findAll();
	User save(@Valid User user);
	User update(@Valid User user);
}