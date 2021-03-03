package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;

@Service
public interface StudentService {
	
	public ArrayList<StudentDTO> getListStudent();
	
	public StudentDTO getListStudentById(int id);
	
	public Student addStudent(Student student);
	
	public Student updateStudent(Student student);
	
	public boolean deleteStudent(int id);
	
	

}
