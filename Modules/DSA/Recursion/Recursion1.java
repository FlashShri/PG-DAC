

class Recursion1{
	static int i =0;
	static void show(){
		if( i < 5) // base case
		{
			System.out.println(i);
			i++;
			show(); // calling itself
		}
	}
	public static void main(String[] args) {
		show();
	}
}




// class Recursion1{

// 	// recursive fun 
// 	static void show1(){
// 		System.out.println("This is show()...");
// 		System.out.println("some code /....");
// 		show2(); // calling itself
// 	}

// 	static void show2(){
// 		System.out.println("this is show2...");
// 		show1();
// 	}

// 	public static void main(String[] args) {
		
// 		show1();
// 	}
// }

// // Exception in thread "main" java.lang.StackOverflowError
// class Recursion1{

// 	// recursive fun 
// 	void show(){
// 		System.out.println("This is show()...");
// 		System.out.println("some code /....");
// 		show(); // calling itself
// 	}

// 	public static void main(String[] args) {
// 		Recursion1 r = new Recursion1();
// 		r.show();
// 	}
// }