package com.assignment1;

public class Teacher extends Person{

	private int employeeId;
	protected String subject;
	public Teacher(){
		this.employeeId = 0;
		this.subject = "";
	}
	public Teacher(String name,int age ,char gender,int employeeId,String subject){
		super(name,age,gender);;
		this.employeeId = employeeId;
		this.subject = subject;
	}

	public void displayTeacherDetails(){

		System.out.println("Teacher name: "+this.name);
		System.out.println("Teacher age: "+this.age);
		System.out.println("Teacher gender: "+this.gender);
		System.out.println("Teacher employeeId:  "+this.employeeId);
		System.out.println("Teacher's subject: "+this.subject);

	}
}