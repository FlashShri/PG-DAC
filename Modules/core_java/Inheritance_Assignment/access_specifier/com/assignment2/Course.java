
package com.assignment2;

public class Course{
	private String courseName;
	protected String courseCode;

	public Course(){
		this.courseName = "";
		this.courseCode = "";
	}

	public Course(String courseName,String courseCode){
		this.courseName = courseName;
		this.courseCode = courseCode;
	}

	public void displayCourseDetails(){
		System.out.println("Course name: "+this.courseName);
		System.out.println("Course code: "+this.courseCode);
	}
}