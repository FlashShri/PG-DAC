package com.assignment1;

public class Student extends Person{

	 int studentId;
	 char grade;

	public Student(){
		this.studentId = 11;

		this.grade= 'Z';
	}
	
	public Student(String name,int age ,char gender,int studentId,char grade ){
		super(name, age, gender);
		this.studentId = studentId;
		this.grade = grade; 	
	}
	public void displayStudentDetails(){

		System.out.println("Student name: "+this.name);
		System.out.println("Student age: "+this.age);
		System.out.println("Student gender"+this.gender);
		System.out.println("Student studentId: "+this.studentId);
		System.out.println("Student grade: "+this.grade);

	}
}