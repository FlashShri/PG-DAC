
import java.util.*;
import java.io.*;
public class Fibonacci{



	public static void main(String[] args) {
		// int num1 = 0;
		// int num2 = 1;
		// int temp;
		// int count = 10 ;
		// System.out.print(num1+ " "+ num2);
		// for(int i = 2; i < count ;i++){
		// 	temp= num2 + num1 ;
		// 	System.out.print(" "+temp );
		// 	num1 = num2 ;
		// 	num2 = temp;
		// }



		Scanner in = new Scanner(System.in);
        char ch = in.nextline();

        int chas = ch ;
        if(chas >= 97 && chas <= 122){
            System.out.println(0);

        }else if(chas >=65 && chas <= 90){
            System.out.println(1);
        }else{
            System.out.println(-1);
        }

        
	}
}