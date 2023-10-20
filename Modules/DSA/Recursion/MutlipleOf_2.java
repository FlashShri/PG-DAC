
class MutlipleOf_2{

	static int power(int n){
		if(n<1) return 1;
		else 
			return 2*power(n-1);

		// if(n==4)
		// 	return n;
		// else 
		// 	return 2*power(n+1);

	}
public static void main(String[] args) {
	System.out.println(power(4));
}
}