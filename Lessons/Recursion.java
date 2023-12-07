
class recursion {
  public static void main (String [] args){
    // recursion is like a fancier version of a while loop.
    // recursion makes your code really neat
    rec1(3);
    rec1(-5);
    rec1(0);
  }
	public static void rec1(int a) {
      if (a == 0) {
        // base case
        System.out.println("got to 0\n");
        return; //if you don't have this, it'll make the console constantly loop
        		// so make sure to have return.
      } else {
        //recursion
        System.out.println("at a = " + a);
      }
      if (a > 0) {
        rec1(a-1); 
      } else {
        rec1(a + 1);
      }
    }
  
 
  // another example:
  public static int sumOfN(int n) {
    if (n == 0) return 0;
    return n + sumOfN(n-1);
    // *son = sun of n, it's an acronym 
    
    // son(5) : return 5 + son(4) 5 + 10 = 15
    // son(4) : return 4 + son(3) 4 + 6 = 10
    //(3) : 3 + son(2) 3 + 3 = 6
    //(2) : 2 + son(1) 2 + 1 = 3
    //(1) : 1 + son(0) 1 + 0 = 1
    //(0) : 0
  }
  
  public static int fact /*factorial*/ (int n) {
    if (n == 0) return 1;
    return n * fact(n-1);
  }
  // search up fibonacci sequence. Sum of the previous two numbers
  public static int fib /*fibonacci number*/ (int n) {
    return fib(n-1) + fib(n-2);
  }
}
