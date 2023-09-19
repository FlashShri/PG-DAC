#include"../include/IllegalArgumentException"
using namespace exception;
#include <string>
using namespace std;

IllegalArgumentException::IllegalArgumentException(string message): message (message){

}
string IllegalArgumentException::getMessage(void )const{
	return this->message;
}