/*
. Create a class called Student with the following private data members:
 name (string): to store the name of the student.
rollNumber (int): to store the roll number of the student.
marks (float): to store the marks obtained by the student.
grade (char): to store the grade calculated based on the marks.
Implement getter and setter member functions for each data member
Create a member function calculateGrade() that calculates the grade based on the following
grading scale:
 A: 90-100
 B: 80-89
 C: 70-79
 D: 60-69
 F: Below 60
Implement a menu-driven program in the main() function with the following options:
Accept Information
Display information
Calculate Grade
Exit the program.
*/

#include <string>
#include <iostream>
using  namespace std;

class Student{
private:
	std::string name;
	int rollNumber;
	float marks;
	char grade;

public :

	Student(void){
		this->name = "xyz";
		this->rollNumber = 00;
		this->marks = 00;
		this->grade = 'x';
	}

	// setters
	void setName(std::string name){
		this->name = name;
	}
	void setRollNumber(int rolNumber ){
		this->rollNumber= rolNumber;
	}
	void setMarks( float marks ){
		this->marks= marks;
	}
	void setGrade(char grade){
		this->grade = grade;
	}

	// getters
	string getName(){
		return this->name;
	}
	int getRollNumber(){
		return this->rollNumber;
	}
	float getMarks(){
		return this->marks;
	}
	char getGrade(){
		return this->grade;
	}

	// fun to invoke setter

};

int menu_list(){

	int choice;
	cout << "!!! Students Admin Page !!!" << endl;
	cout << "1.Accept Information"<<endl;
	cout << "2.Calculate Grade"<<endl;
	cout << "3.Display information"<<endl;
	cout << "0.Exit the program."<<endl;
	cin >> choice ;

	return choice;

}
void acceptInfo(Student *st){

	std::string name;
	int rollNumber;
	float marks;

	cout<<"Enter name : "<<endl;
	cin >> name ;
	cout<<"Enter Roll Number : "<<endl;
	cin>> rollNumber;
	cout<<"Enter marks : "<<endl;
	cin >> marks ;

	st->setName(name);
	st->setRollNumber(rollNumber);
	st->setMarks(marks);

}
void showInfo(Student *st){

	cout << "Student name : " << st->getName()<<endl;
	cout << "Student roll number : " << st->getRollNumber()<<endl;
	cout << "Student marks : " << st->getMarks()<<endl;
	cout << "Student grade : " << st->getGrade()<<endl;
}

void calculateGrade (Student *st){
	int grade = st->getMarks();
	if(grade <= 100 && grade >= 90){
		st->setGrade('A');
	}else if(grade < 90 && grade >= 80){
		st->setGrade('B');
	}
	else if(grade < 80 && grade >= 70){
		st->setGrade('C');
	}else if(grade < 70 && grade >= 60){
		st->setGrade('D');
	}else if(grade < 60 ){
		st->setGrade('F');
	}
}
int main( void ){
	Student s ;
	int choice;
	while ( (choice = ::menu_list()) != 0 ){

		switch (choice){
		case 1: ::acceptInfo(&s); cout <<s.getName()<<endl ;
				break;
		case 2: ::calculateGrade(&s) ;cout <<s.getGrade()<<endl ;break;
		case 3: ::showInfo(&s) ;break;
		}
	}
}
