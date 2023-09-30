/*
     *
    **
   ***
  ****
 *****
 *****
  ****
   ***
    **
     *
*/

public class Pattern9{
	public static void main(String[] args) {
		
		int row =10;
		int half = row /2 ;

		for(int i=0; i < half ; i++){
			for(int j = 0 ; j < half-i ; j++){
				System.out.print(" ");
			}
			for(int j =0 ; j <=i ;j++){
				System.out.print("*");
			}
			System.out.println();
		}

		// condition for even and odd no of rows
		if(row%2 != 0 ){
			for(int i =0 ; i <=half; i++){
			System.out.print("*");
			
			}
			System.out.println();
		}

		//inverse
		for(int i =half ; i > 0 ; i--){
			for( int j =half ; j >= i ; j--  ){
			System.out.print(" ");
			}
			for(int j =i ; j > 0; j--){
				System.out.print("*");
			}
			System.out.println();

		}
	}
}