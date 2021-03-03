package com.example.demo.controller;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService listStudent;

	@GetMapping
	public ArrayList<StudentDTO> getListStudent() {	
		ArrayList<StudentDTO> list = listStudent.getListStudent();
		return list;
	}
	
	@GetMapping("/{id}")
	public StudentDTO getListStudentById(@PathVariable int id) {
		StudentDTO student = listStudent.getListStudentById(id);
		return student;
	}
	
	@PostMapping
	public ResponseEntity addStudent(@RequestBody Student student) {
		Student st = listStudent.addStudent(student);
		int code = 200;
		JSONObject result = new JSONObject();
		
		if(st == null) {			
			result.put("messsage", "Student ID already exists.");
			code = 409;
		} else {
			result.put("result", st);
			result.put("message", "Student created successfully.");
		}
		return ResponseEntity.status(code).body(result);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity updateStudent(@PathVariable int id, @RequestBody Student student) {
		student.setId(id);
		Student st = listStudent.updateStudent(student);
		int code = 200;
		JSONObject result = new JSONObject();
		
		if(st == null) {			
			result.put("messsage", "Student ID is not exists.");
			code = 409;
		} else {
			result.put("result", st);
			result.put("message", "Student updated successfully.");
		}
		
		return ResponseEntity.status(200).body(result);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteStudent(@PathVariable int id) {
		boolean check = listStudent.deleteStudent(id);
		int code = 200;
		JSONObject result = new JSONObject();
		if(check) {			
			result.put("messsage", "Student deleted successfully.");
		} else {
			result.put("messsage", "Student ID is not exists.");
			code = 409;
		}
		return ResponseEntity.status(code).body(result);
	}
}
