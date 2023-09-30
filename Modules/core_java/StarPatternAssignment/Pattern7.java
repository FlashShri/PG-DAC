public class Pattern7{

	public static void main(String[] args) {
		int row = 10 ;
		int half = row / 2 ; // hr+1 => middle

		// upper pyramid
		for(int i=0 ; i < half ; i++ ){
			for(int j =0 ; j < half-i;j++){
				System.out.print(" ");
			}
			for(int k=0 ; k <=i ;k++){
				System.out.print("*");
			}
			for(int p=0; p < i;p++){
				System.out.print("*");
			}
			System.out.println();
		}

		// condition for even and odd no of rows
		if(row%2 != 0 ){
			for(int i =0 ; i <row; i++){
			System.out.print("*");
		}
		}else{
			for(int i =0 ; i <=row; i++){
			System.out.print("*");
		}
		}
		System.out.println();


		//inverse pyramid
		for(int i =0 ; i < half ; i++ ){
			for(int j=0;j <= i;j++){
				System.out.print(" ");
			}
			for(int k=0; k < half -i; k++){
				System.out.print("*");
			}
			for(int p =half ; p > i+1 ; p--){
				System.out.print("*");
			}
			System.out.println();
		}


	}
	// 9X9  => middle 9 -2 = 7
	// 10X10 => 
	

	// for(int i =0 ; i < row; i++ ){

	// 	for(int j = 0; j < half; j++ ){
	// 		System.out.print(" ");
	// 	}
	// 	for(int k)


	// }


	

}