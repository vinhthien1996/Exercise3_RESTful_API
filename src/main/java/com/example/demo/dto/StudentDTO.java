package com.example.demo.dto;

public class StudentDTO {

	private int id;
	private String name;
	private float math;
	private float physical;
	private float english;
	private float gpa;

	public StudentDTO() {
		super();
	}

	public StudentDTO(int id, String name, float math, float physical, float english, float gpa) {
		super();
		this.id = id;
		this.name = name;
		this.math = math;
		this.physical = physical;
		this.english = english;
		this.gpa = gpa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMath() {
		return math;
	}

	public void setMath(float math) {
		this.math = math;
	}

	public float getPhysical() {
		return physical;
	}

	public void setPhysical(float physical) {
		this.physical = physical;
	}

	public float getEnglish() {
		return english;
	}

	public void setEnglish(float english) {
		this.english = english;
	}

	public double getGpa() {
		return (double) Math.round(gpa * 10)/10;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

}
