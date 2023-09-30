public class Pattern15{
	public static void main(String[] args) {
		int row = 5; 
		
      for(int i=1;i<=row;i++)
      {
         if(i==1 || i==row)
         {
         	for(int j=1;j<=i;j++){
            System.out.print("*");
         	} 
         
         }
         else {
             for(int j=1;j<=i;j++){
                if(j==1 || j==i)
                   System.out.print("*");
                else
                   System.out.print(" ");
            }
         }
      System.out.println();
      }
	}
}