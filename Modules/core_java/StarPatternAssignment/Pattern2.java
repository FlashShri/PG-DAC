//Pattern2
/*
    *
   **
  ***
 ****
*****
*/
public  class Pattern2{
	public static void main(String[] args) {
		for(int i=0; i < 5 ; i++){

			for(int j = 0 ; j < 5-1-i ; j++){
				System.out.print(" ");
			}
			for(int k =0; k <= i;k++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
/*
    1
   12
  123
 1234
12345
*/

// public  class Pattern2{
// 	public static void main(String[] args) {
// 		for(int i=0; i < 5 ; i++){

// 			for(int j = 0 ; j < 4-i ; j++){
// 				System.out.print(" ");
// 			}
// 			int s =1 ;
// 			for(int k =0; k <= i;k++){
// 				System.out.print(s);
// 				s++;
// 			}
// 			System.out.println();
// 		}
// 	}
// }