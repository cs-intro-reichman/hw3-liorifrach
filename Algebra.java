// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int result = x1; 
		while (x2 > 0) {
			x1 ++; 
			x2--;
		}
		while (x2 < 0) {
			x1 --; 
			x2 ++;
		}
		result = x1;
		return result;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		
		while (x2 > 0) {
				x1--; 
				x2--;
		}
		while (x2 < 0) {
				x1++; 
				x2++;
		}
		 
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		int result = 0;
		if (x1 > 0) {
			if ( x2 > 0){
				for (int i = 0; i < x2; i++){
					result = plus(result,  x1);
				}
			}
			else if (x2 < 0){
				for (int i= 0; i < minus(0, x2); i++){
					result = plus(result, x1);
				}
				result = minus(0, result);
			}
		}

		if (x1 < 0){
			if (x2 < 0){
				// x1, x2 to a positive numbers
				int j1 =  minus(0, x1);
				int j2 =  minus(0, x2);
				for (int i = 0; i < j2; i++){
					result = plus(result, j1);
				}
			}
			else if (x2 > 0){
				for (int i=0; i < x2; i++){
					result = plus(result, x1);
				}
			}
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		int result = 1; // every num^0 = 1	
		for (int i = 0; i < n; i++){
			result = times(result, x);
		}
		return result;
	}


	public static int div(int x1, int x2) {
		int count = 0;
		int signx1 = 0;
		int signx2 = 0;
		// להחזיר שגיאה אם x2 = 0 
		if (x1 < 0){
			signx1 = 1;
			x1 = minus(0, x1);
		}
		if (x2 <0){
			signx2 =1;
			x2 = minus(0, x2);
		}
			
		while (x1 >= x2) {
					x1 = minus(x1, x2);
					count ++;
		}
		if (signx1 != signx2){
			count = minus(0, count);
		}
		
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int count = 0;
		if (x1 < 0){
			x1 = minus(0, x1);
			if (x2 < 0){
				x1 = minus(0, x2);
				while (x1 >= x2) {
					x1 = minus(x1, x2);
					count ++;
				}
			}
			else if (x2 > 0){
				while (x1 >= x2) {
					x1 = minus(x1, x2);
					count --; 
				}
			}
		}
		else if(x1 > 0){
			if(x2 > 0){
				while (x1 >= x2) {
					x1 = minus(x1, x2);
					count ++;
				}
			}
			else if(x2 < 0){
				x2 = minus(0, x2);
				while (x1 >= x2) {
					x1 = minus(x1, x2);
					count --; 
				}
			}
		}
		
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Replace the following statement with your code
		if (x == 0 || x == 1){
			return x;
		}
		int a = 0;
		while (times(a + 1, a + 1) <= x){
			a ++;
		}
		return a;
	}	  	  
}