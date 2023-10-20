
// class A1{
// 	static int i =1;
// 	static  void  printEven(int n ){
// 		if( i >= n){
// 			return ;
// 		}
// 		if(i%2 ==0){
// 			System.out.println(i+" ");

// 			printEven(++i);
// 		}else{
// 			printEven(++i);
// 		}
		
// 	}
// 		public static void main(String[] args) {
		
// 		printEven(10);
// 	}
// }


// class A1{
// 	static int i =2;
// 	static  void  printEven(int n ){
// 		if( n <= 0){
// 			return ;
// 		}
// 		if(n%2 ==0){
// 			System.out.println(n+" ");
// 		}
// 			printEven(n-1);
// 	}
// 		public static void main(String[] args) {
		
// 		printEven(10);
// 	}
// }

class A1{
	static int i =2;
	static  void  printOdd(int n ){
		if( n <= 0){
			return ;
		}
		if(n%2 != 0 ){
			System.out.println(n+" ");
		}
			printOdd(n-1);
	}
		public static void main(String[] args) {
		
		printOdd(10);
	}
}
