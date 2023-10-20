
class TowerOFHanoi{
	static void toh(int n, char src , char aux, char des){

		if(n == 1){
			System.out.println("disk from: "+src+" to "+des);
		}else{
		toh(n-1,src,des,aux);
		System.out.println("disk from: "+src+" to "+ des);
		toh(n-1,aux,src,des);	
		}
		
	}
	public static void main(String[] args){
		int n =4;
		toh(n , 'A','B','C');
	}
}