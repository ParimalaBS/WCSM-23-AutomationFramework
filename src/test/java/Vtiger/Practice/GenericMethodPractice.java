package Vtiger.Practice;

public class GenericMethodPractice {

	public static void main(String[] args) {
		
	// Caller method
		int c=add(10,30);
		System.out.println(c);
		int g= sub(60,90);
		System.out.println(g);
		int r= mul(4,3);
		System.out.println(r);
		 }
	
	 // Called method- addition
	   public static int add(int a, int b) {
			int c= a+b;
			return c;
		}
	   
	  // Called method - Subtraction
	  public static int sub(int e,int f) {
		  int  g= e-f;
		  return g;
	  }
	  
	  // Called method- multiplication
	  public static int mul(int p , int q) {
		  int r= p*q;
		  return r;
	  }

}
