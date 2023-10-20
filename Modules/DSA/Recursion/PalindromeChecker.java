
class PalindromeChecker{

	static boolean check(int n){
		int temp = n;
		int res =0 ;
		int i ;
		while(n > 0){

		 i = n%10;
		res = (res*10) + i;
		n = n/10;
		}
		

		if(temp == res){return true;}


		return false;
	}
	public static void main(String[] args) {
		int num = 232;
		System.out.println("is palindrome: "+ check(num));
	}
}