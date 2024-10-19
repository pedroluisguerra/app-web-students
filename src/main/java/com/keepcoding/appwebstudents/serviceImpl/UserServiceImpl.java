package com.keepcoding.appwebstudents.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepcoding.appwebstudents.entity.User;
import com.keepcoding.appwebstudents.repository.UserRepository;
import com.keepcoding.appwebstudents.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createNewUser(User user) {
		// Crea un nuevo usuario
		return userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {
		// Busca por email
		return userRepository.findByEmail(email);
	}

	@Override
	public User findByEmailOrUsername(String email, String username) {
		// Busca por email o username
		return userRepository.findByEmailOrUsername(email, username);
	}
	
	

}
