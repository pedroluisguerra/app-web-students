package com.keepcoding.appwebstudents.service;

import com.keepcoding.appwebstudents.entity.User;

public interface UserService {
	
	// Método para guardar un nuevo usuario
	User createNewUser(User user);
	
	// Método para buscar por email or username
	
	User findByEmail(String email); 
	
	User findByEmailOrUsername(String email, String username);

}
