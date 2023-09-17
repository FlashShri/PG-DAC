#include<string>
#include<iostream>
using namespace std;

class BankAccount{
private:
	int accountNumber;
	std::string acHolderName;
	double balance;
public :
	BankAccount(){
		this->acHolderName = "Elon Musk";
		this->accountNumber = 9765476;
		this->balance = 9999999999;
	}
	BankAccount(int accountNumber, std::string acHolderName,  double balance){
		this->acHolderName = acHolderName;
		this->accountNumber = accountNumber;
		this->balance = balance;
	}

	// setters
	void setAcNumber(int accountNumber ){
		this->accountNumber = accountNumber;
	}
	void setAcName( std::string acHolderName ){
		this->acHolderName = acHolderName;
	}
	void seAcBalance(double balance){
		this->balance = balance;
	}

	//getters
	int getAcNumber(){
		return this->accountNumber;
	}
	std::string getAcName(){
		return this->acHolderName;
	}
	double getBalance(){
		return this->balance;
	}

};
void createAc(BankAccount *ac){

	int accountNumber;
	std::string acHolderName;
	double balance;

	cout<<"Enter Account Num : "<<endl;
	cin >> accountNumber;
	cout << "Enter Ac Holder Name : "<<endl;
	cin >> acHolderName;
	cout<<"Enter balance : "<<endl;
	cin >> balance;

	ac->setAcNumber(accountNumber);
	ac->setAcName(acHolderName);
	ac->seAcBalance(balance);

	cout<<"New account is successfully created!!!!!"<<endl;

}

int menu_list(){
	int choice;
	cout<<"~~~~~~ Enter choice ~~~~~"<<endl;
	cout<<"1 - Deposit money into an existing account"<<endl;
	cout<<"2 - Withdraw money from an existing account"<<endl;
	cout<<"3 - Display the account details"<<endl;
	cout<<"0 - Exit the program"<<endl;
	cin >> choice ;

	return choice;
}

void deposite(BankAccount *bpt){
	double amount ;
	cout<<"Enter amount to deposite : "<<endl;
	cin >> amount;

	double updatedBalance;
	updatedBalance = bpt->getBalance() +amount;
	bpt->seAcBalance( updatedBalance );
	cout<< "Remaining Balance : "<< bpt->getBalance()<<endl;

}

void withdraw(BankAccount *bpt){
	double amount;
	cout<<"Enter amount to withdraw : "<<endl;
	cin >> amount;

	double remainingBal;
	remainingBal = bpt->getBalance() - amount;
	bpt->seAcBalance( remainingBal );

	cout<< "Remaining Balance : "<< bpt->getBalance()<<endl;
}

void displayAcDetails(BankAccount *bpt){

	cout << "User Details:::"<<endl;
	cout<<"Account Number  : "<< bpt->getAcNumber()<<endl;
	cout<<"Account Holder Name  : "<<bpt->getAcName()<<endl;
	cout<<"Account Balance : "<<bpt->getBalance()<<endl;
}

int main ( void ){

	BankAccount b;
	::createAc(&b);

	int choice;
	while( (choice = ::menu_list()) != 0){

		switch(choice){
		case 1: ::deposite(&b) ; break;
		case 2: ::withdraw(&b) ; break;
		case 3: ::displayAcDetails(&b);break;
		}
	}
	return 0;

}
