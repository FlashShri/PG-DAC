class Fibonacci{

	static int fib(int n){
		if(n<=1){
			return n;

		}
		else{
			return fib(n-1)+fib(n-2);
		}
	}

	public static void main(String[] args) {
		int num = 50;
		for(int i=1; i<=num ; i++){
			System.out.print(fib(i)+" ");
		}
		
	}
}


// class Fibonacci{

// 	static int fib(int n){
// 		if(n<=1){
// 			return n;

// 		}
// 		else{
// 			return fib(n-1)+fib(n-2);
// 		}
// 	}

// 	public static void main(String[] args) {
// 		System.out.println(fib(5));
// 	}
// }

// Tower of Hanoi
// if disk no is 3
// then no of moves will be 2^n-1 