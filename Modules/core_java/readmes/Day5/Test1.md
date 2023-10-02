```java


public class ArrayChallenge{
	public static void main(String[] args) {
		
		int arr[] = {0,2,4,6,8};

		int brr[] = arr ;

		for(int i =0 ; i < brr.length ; i ++){
			System.out.println(brr[i]);
		}

		addElements(arr);
		addElements(brr);

		for(int i:arr){
			System.out.println(i);
		}
	}

	public static void addElements(int[] arr){
		for( int i=0; i < arr.length; i++){
			arr[i] = arr[i] + 2 ;
		}
	}
}

class Test{
	public static void main(String[] args) {
		 int a[]  = {1,2,3,4,5,6,7};
		int b[] ;
		b = a ;
		int index = 0;
		System.out.println(b[index + 3]);
		System.out.println(a[index + 3]);

	}
}

class Test1 {
    public static void main(String[] args) {
        int[] a = { 2, 4, 8, 16 ,32 };
        int[] b = { 0, 1, 2, 3 };
        System.out.println(a[b[3]]);
    }
}


class Test1 {
    public static void main(String[] args) {
      int i = 3;
        int arr[][] = new int[i][i=2];
        System.out.println(arr.length + " " + arr[2].length );
    }
}

class Point { int x, y; }
class ColoredPoint extends Point { int color; }
class Test {
    public static void main(String[] args) {
        ColoredPoint[] cpa = new ColoredPoint[10];
        Point[] pa = cpa;
        System.out.println(pa[1] == null);
        try {
            pa[0] = new Point();
        } catch (ArrayStoreException e) {
            System.out.println(e);
        }
    }
}


class Test2 {
    public static void main(String[] args) {
        int[] ia = new int[3];
        int[] ib = new int[6];
        System.out.println(ia == ib);
        System.out.println(ia.getClass() == ib.getClass());
    }
}

byte[] rowvector, colvector, matrix[];

 int []arr , row ,col;
        row = new int[3];
        System.out.println(row.length);  // 3


  String String = "CDAC_MUMBAI";
  System.out.println(String);

    int naruto = 45;
  int goku = 10;
  int luffy = 3;

  if(naruto == 46 & goku++ == 10){
  	luffy++ ;
  }
   if(++luffy == 3 | naruto++ == 46){
  	luffy++;
  }

  System.out.println(naruto+" "+goku+" "+luffy); //46 11 4
```