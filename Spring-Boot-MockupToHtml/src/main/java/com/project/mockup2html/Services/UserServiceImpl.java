package com.project.mockup2html.Services;


import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.mockup2html.Models.User;
import com.project.mockup2html.Repositories.UserRepository;


@Repository
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	
	@Transactional
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	@Transactional
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	@Transactional
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	@Transactional
	@Override
	public User save(@Valid User user) {
		return userRepository.save(user);
	}
	@Transactional
	@Override
	public User update(@Valid User user) {
		return userRepository.update(user);
	}


}