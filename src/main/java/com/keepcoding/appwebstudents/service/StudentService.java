package com.keepcoding.appwebstudents.service;

import java.util.List;

import com.keepcoding.appwebstudents.entity.Student;

public interface StudentService {
	
	// Método para listar todos los alumnos
	List<Student> listStudents();
	
	// Método para buscar un alumno por dni
	
	Student findbyDni(String dni);
	
	// Método para guardar un nuevo alumno
	
	Student registerStudent(Student student);
	
	// Método para actualizar el registro de un alumno
	
	Student updateStudent(Student student);
	
	// Método para borrar un registro de estudiante
	
	void deleteByDni(String dni);

}
