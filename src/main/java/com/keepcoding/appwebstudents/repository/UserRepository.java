package com.keepcoding.appwebstudents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keepcoding.appwebstudents.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	User findByEmailOrUsername(String email, String username);

}
