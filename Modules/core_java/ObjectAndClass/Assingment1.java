import java.util.*;
 class Book{
	String title ;
	String author ;
	double price;
static	double totalPrice = 0.0 ;

	Book(){
		this.title = " ";
		this.author = " ";
		this.price = 0.0;
	}

	Book(String title, String author,double price){
		this(title,author);
		this.price = price;
	}
	Book(String title, String author){
		this();
		this.title = title;
		this.author = author;
	}

	void displayBookData(){
		System.out.println("title:  "+this.title);
		System.out.println("author:  "+this.author);
		System.out.println("price:  "+this.price);
	}

	void changePrice(double newPrice){
		this.price = newPrice;
	}
	void totalPrice( ){
		totalPrice += this.price;
	}

}

public class Assingment1{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter no books: ");
	int n = sc.nextInt();
	sc.nextLine();
	Book b1[] = new Book[n];

	for(int i =0 ; i < n ;i++){
		System.out.println(i+1 + "enter book detail: ");
		String t , a;
		double p;
		System.out.println("enter title: ");
		t = sc.nextLine();
		System.out.println("enter author: ");
		a = sc.nextLine();
		System.out.println("enter price: ");
		p = sc.nextDouble();
		b1[i] = new Book(t,a,p);
		sc.nextLine();
	}

	System.out.println("enter no of book to change its price: ");
	int num = sc.nextInt();

	b1[num].changePrice(234);

	for( int i= 0 ; i < n  ;i++){
		b1[i].totalPrice();
	}


	for(int i =0 ; i < n ; i++){
		b1[i].displayBookData();
	}


	}
}