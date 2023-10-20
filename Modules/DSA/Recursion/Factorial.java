class Factorial{

	static int factorial(int n){
		if(n <= 1){
			return 1;
		}else{
			return n * factorial(n-1);
		}
	}
	public static void main(String[] args) {
		System.out.println(factorial(5)); // 120
	}
}

// 5*4*3*2*1
// n*(n-1)*(n-2)*(n-3)*(n-4)
// 
// n*(n-1)=> 5*(5-1)=> 