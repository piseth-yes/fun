/* 
class recrusion2 {
  public static void main(String[] args) {
    int [] arr = {34,70,57,37,16,16,53,18,46,15,59,100,33,45,6,45,31,19,39,31};
    
    String s1 = "as3f3sa";

    
    //System.out.println(isPalindrome(s1, 0, s1.length()-1));
    System.out.println(Arrays.toString(arr));
    recSelectionSort(arr);
    System.out.println(Arrays.toString(arr));
    
    
    for (int i = 0; i < 100; i++) {
      	if(recBinarySearch(arr, i) != -1) {
    	system.out.print(recBinarySearch(arr, 6))
        }
    }
  }
  
  public static boolean isPalindrome(String input) {
    return isPalindrome(input, 0, input.length());
  }
  
  public static boolean isPalindrome(String input, int start, int end) {
    if (end <= start) return true;
    if(input.charAt(start) != input.charAt(end-1)) return false;
    return isPalindrome(input, start+1, end-1); // this is where the recursion is btw
  }
  
  
  
  
  
  
  
  //helper method
  public static void recSelectionSort(int[] arr) {
    recSelectionSort(arr,0);
  }
  
  //seperate part: Selection sort recursion
  public static void recSelectionSort(int [] arr, int start) {
    if (start >= arr.length) return;
    int minIdx = start;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < arr[minIdx]) minIdx = i;
    }
    //swap values of min and start
    //puts smallest value at the start
    int temp = arr[minIdx];
    arr[minIdx] = arr[start];
    arr[start] = temp;
    recSelectionSort(arr, start+1);
  }
  
  
  
  
  
  
  
  public static int recBinarySearch(int[] arr, int target) {
    return recBinarySearch(arr, target, 0, arr.length);
  
  public static int recBinarySearch(int [] arr, int target, int start, int end) {
    if (start > end) return -1;
    int mid = (start  + end) / 2;
    if(arr[mid] ==  target) return mid;
    if(arr[mid] > target) return recBinarySearch(arr, target, start, mid -1);
    return recBinarySearch(arr, target, mid + 1, end);
    return 0;
    
  }
  
}
*/

/* 
   as long as end is bigger than start, 
   
   find mid
   if mid is the target, then return mid
   if target is bigger than mid, search larger half
   if target is smaller than mid, serach smaller half
  */


    /*how it works: 
    1 2 3 4 5 6 7 (the array)
    a s 3 f 3 s a
    
    outputs: 0,7
    		 1,6
             2,5
             3,4
             4,3
    
    */