package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;

@Component
public class StudentServiceImpl implements StudentService {

	private static ArrayList<Student> students = new ArrayList<Student>();

	static {
		students.add(new Student(1, "Nguyễn Văn A", 7, 8, 9));
		students.add(new Student(2, "Nguyễn Văn B", 5, 7, 6));
		students.add(new Student(3, "Nguyễn Văn C", 9, 7, 9));
		students.add(new Student(4, "Nguyễn Văn D", 9, 10, 9));
		students.add(new Student(5, "Nguyễn Văn E", 6, 5, 7));
	}

//	GET LIST USER
	@Override
	public ArrayList<StudentDTO> getListStudent() {
		ArrayList<StudentDTO> listStudentFull = new ArrayList<StudentDTO>();

		for (Student student : students) {
			float gpa = (student.getMath() + student.getPhysical() + student.getEnglish()) / 3;

			StudentDTO dto = new StudentDTO(student.getId(), student.getName(), student.getMath(),
					student.getPhysical(), student.getEnglish(), gpa);
			listStudentFull.add(dto);
		}
		return listStudentFull;
	}

//	GET STUDENT BY ID
	@Override
	public StudentDTO getListStudentById(int id) {
		for (Student student : students) {
			if (student.getId() == id) {
				float gpa = (student.getMath() + student.getPhysical() + student.getEnglish()) / 3;
				StudentDTO dto = new StudentDTO(student.getId(), student.getName(), student.getMath(),
						student.getPhysical(), student.getEnglish(), gpa);
				return dto;
			}
		}

		return null;
	}

//	ADD STUDENT
	@Override
	public Student addStudent(Student student) {
		if (getListStudentById(student.getId()) != null) {
			return null;
		}

		students.add(student);
		return student;
	}

//	UPDATE STUDENT
	@Override
	public Student updateStudent(Student student) {
		for (Student item : students) {
			if (item.getId() == student.getId()) {
				item.setId(student.getId());
				item.setName(student.getName());
				item.setMath(student.getMath());
				item.setPhysical(student.getPhysical());
				item.setEnglish(student.getEnglish());
				return item;
			}
		}
		return null;
	}

//	DELETE STUDENT
	@Override
	public boolean deleteStudent(int id) {
		int index = 0;
		for (Student student : students) {
			if (student.getId() == id) {
				students.remove(index);
				return true;
			}
			index++;
		}
		return false;
	}

}
