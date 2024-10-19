package com.keepcoding.appwebstudents.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keepcoding.appwebstudents.entity.Student;
import com.keepcoding.appwebstudents.repository.StudentRepository;
import com.keepcoding.appwebstudents.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> listStudents() {
		// Lista todos los estudiantes
		return studentRepository.findAll();
	}
	
	@Override
	public Student findbyDni(String dni) {
		// Busca por dni
		return studentRepository.findByDni(dni);
	}

	@Override
	public Student registerStudent(Student student) {
		// Registro de un alumno nuevo
		return studentRepository.save(student);
	}

	@Override
	@Transactional
	public void deleteByDni(String dni) {
		studentRepository.deleteByDni(dni);
		
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
