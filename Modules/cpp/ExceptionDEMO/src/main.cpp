#include<iostream>
#include<string>
#include"../include/IllegalArgumentException"
#include"../include/Complex"
using namespace std;
using namespace exception;
using namespace nutil;


void accept_record( Complex &c1 ){
	int real;
	cout << "Enter real number	:	";
	cin >> real;
	c1.setReal( real );

	int imag;
	cout << "Enter imag number	:	";
	cin >> imag;
	c1.setImag( imag );
}
void print_record( const Complex &c1 )throw( ){
	cout << "Real Number	:	" << c1.getReal( ) <<endl;
	cout << "Imag Number	:	" << c1.getImag( ) <<endl;
}
int menu_list( ){
	int choice;
	cout << "0.Exit." <<endl;
	cout << "1.Accept Record." <<endl;
	cout << "2.Print Record." <<endl;
	cout << "Enter choice	:	";
	cin >> choice;
	return choice;
}
int main( void ){
	int choice;
	Complex c1;
	while( ( choice = ::menu_list( ) ) != 0 ){
		try{
			switch( choice ){
			case 1:
				::accept_record( c1 );
				break;
			case 2:
				::print_record( c1 );
				break;
			}
		}catch( IllegalArgumentException &ex ){
			cout << ex.getMessage( ) << endl;
		}
	}
	return 0;
}
