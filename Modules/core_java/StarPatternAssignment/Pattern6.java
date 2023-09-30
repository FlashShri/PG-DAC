public class Pattern6{
	public static void main(String[] args) {
		int row = 5 ;
		for(int i =0 ; i < row ; i++ ){
			for(int j=0;j < i;j++){
				System.out.print(" ");
			}
			for(int k=0; k < row -i; k++){
				System.out.print("*");
			}
			for(int p =row ; p > i+1 ; p--){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}