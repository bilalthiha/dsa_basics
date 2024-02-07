public class Recursion{
	
	// recursion = When a thing is defined in terms of itself. - Wikipedia
	//			   Apply the result of a procedure, to a procedure.  
	//			   A recursive method calls itself. Can be a substitute for iteration.
	//			   Divide a problem into sub-problems of the same type as the original.
	//			   Commonly used with advanced sorting algorithms and navigating trees
		
	//			   Advantages
	//			   ----------
	//			   easier to read/write
	//			   easier to debug
		
	//			   Disadvantages
	//			   ----------
	//			   sometimes slower
	//			   uses more memory
	
	public static void main(String[] args) {
		
		walk(5);
		System.out.println(factorial(7));
		System.out.println(power(2, 8));
		System.out.println(sum0toN(4));
		System.out.println(reverse("wahaha"));
	}

	private static void walk(int steps) {
		if(steps < 1) return;
		System.out.println("You take a step!");
		walk(steps-1);		
		
	}
	private static int factorial(int num) {
		if(num < 1) return 1;
		return num* factorial(num-1);	    
	}

	private static int power(int base, int exp) {
		if(exp == 0) return 1;
		return base * power(base, exp-1);	    
	}

    public static int sum0toN(int n){
       if(n < 1) return 0;
	   return n + sum0toN(n-1);
    }

    public static String reverse(String s){
		if(s == null || s.length() < 2) return s;
		return reverse(s.substring(1)) + s.charAt(0);        
    }
}
