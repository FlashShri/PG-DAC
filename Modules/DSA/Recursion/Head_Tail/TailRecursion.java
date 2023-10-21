class TailRecursion{
	
	static  void fun(int n){
		if(n<=0){
			System.out.println(0);
			return;
		}
		System.out.println(n);
		fun(n-1);
	}

	public static void main(String[] args) {
		fun(5);
	}
}