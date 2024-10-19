package com.keepcoding.appwebstudents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keepcoding.appwebstudents.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	Student findByDni(String dni);
	
	void deleteByDni(String dni);
	

}
