import com.assignment1.*;

public class Main1{

	public static void main(String[] args) {

		Student s1 = new Student("Elon Musk", 45,'M',717,'A');
		Teacher t1 = new Teacher("Mark",50,'M',875,"C++");

		s1.displayStudentDetails();
		t1.displayTeacherDetails();

	}
}