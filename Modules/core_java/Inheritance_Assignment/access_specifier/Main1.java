
import com.assignment1.*;

public class Main1{

	public static void main(String[] args) {

		Student s1 = new Student("Elon Musk", 45,'M',717,'A');

		//Teacher t1 = new Teacher("Mark",50,'M',875,"C++");

		s1.displayStudentDetails();

		//t1.displayTeacherDetails();


	}

}


// protected displayStudentDetails() => same pkg OK

// .\com\assignment1\Person.java:20: error: illegal combination of modifiers: public and protected
// 	protected public void displayDetails(){
// 	                      ^
// .\com\assignment1\Student.java:21: error: name has private access in Person
// 		System.out.println("Student name: "+this.name);
// 		                                        ^
// .\com\assignment1\Student.java:22: error: age has private access in Person
// 		System.out.println("Student age: "+this.age);
// 		                                       ^
// .\com\assignment1\Student.java:23: error: gender has private access in Person
// 		System.out.println("Student gender"+this.gender);

