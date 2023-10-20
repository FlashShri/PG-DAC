
class Palindrome{
	static int sum = 0;

	static int reverse(int n){
		if( n> 0){
			return sum;
		}else{
			int r = n%10;
			sum = (sum*10)+r;
			 int a=  reverse (n/10);
		}
		return 1;
	}
	static boolean check(int n){
		int temp =n;
		int s = reverse(n);
		if( temp == s){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int num =676;
		System.out.print(check(num));
	}
}