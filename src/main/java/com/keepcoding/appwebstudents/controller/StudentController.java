package com.keepcoding.appwebstudents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.keepcoding.appwebstudents.entity.Student;
import com.keepcoding.appwebstudents.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		
		model.addAttribute("students", service.listStudents());
		
		return "students";
	}
	
	@GetMapping("/students/new")
	public String viewStudentForm(Model model) {
		
		Student student = new Student();		
		model.addAttribute("student", student);
		return "new_student";		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {		
		service.registerStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{dni}")
    public String deleteStudent(@PathVariable("dni") String dni) {
        service.deleteByDni(dni);
        return "redirect:/students";
    }
	
	@GetMapping("/students/edit/{dni}")
	public String editStudent(@PathVariable String dni, Model model) {
		Student editStudent = service.findbyDni(dni);
		
		model.addAttribute("student", editStudent);
		
		return "edit_student";		
	}
	
	@PostMapping("/students/edit/{dni}")
	public String updateStudent(@PathVariable String dni,@ModelAttribute("student") Student student) {
		
		Student updateStudent = service.findbyDni(dni);
		updateStudent.setName(student.getName());
		updateStudent.setSurname(student.getSurname());
		updateStudent.setPhone(student.getPhone());
		updateStudent.setEmail(student.getEmail());
		updateStudent.setDni(student.getDni());
		updateStudent.setBdate(student.getBdate());
		
		service.registerStudent(updateStudent);
		return "redirect:/students"; 
	}
	
	
	@GetMapping("/students/registers/{dni}")
	public String viewStudentRegister(@RequestParam String dni, Model model) {
		Student viewStudentRegister = service.findbyDni(dni);
		
		model.addAttribute("student", viewStudentRegister);
		
		return "student_register";		
	}
	
	
	@PostMapping("/students/register/{dni}")
	public String getStudentRegister(@PathVariable String dni, @ModelAttribute("student") Student student) {
		
		Student viewStudentRegister = service.findbyDni(dni);
		
		service.registerStudent(viewStudentRegister);
		
		return "redirect:/students";
	}
}
