/*


    *
   ***
  *****
 *******
*********


*/

public class pattern5{
	public static void main(String[] args) {
		
		for(int i =0 ; i < 5 ; i++){
			for(int j =0 ; j < 5-1-i ; j++){
				System.out.print(" ");
			}
			for(int k =0 ; k <= i ;k++){
				System.out.print("*");
			}
			

			if( i > 0){
				for(int p = 0 ; p <=i-1 ; p++){
					System.out.print("*");
				}
			}
			System.out.println();


		}

	}
}