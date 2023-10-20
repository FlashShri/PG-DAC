
// sum of series 
class A2{
		static int show(int n){
			if(n < 1){
				return 0;
			}
			else{
				return n+show(n-1); // sum=> n+(n-1)
			}
		}

	public static void main(String[] args) {
		System.out.print(show(10));
	}
}