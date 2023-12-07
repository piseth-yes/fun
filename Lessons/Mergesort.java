
/* 
import java.util.*;
class Mergesort {
  public static void main(String[] args) {
    int [] arr = {34,70,57};
    
    
    System.out.println("Sorted Array");
    
	static int [] mergesort(int [] arr) {
      if (arr.length == 1) {
        return arr;
      }
    
      //below is the important part
      int mid = arr.length / 2;
      int [] left = subArr(arr,0,mid);
      int [] right = subArr(arr,mid,arr.length);
      //above is the important part
      
        left = mergesort(left);
        right = mergesort(right);
      
      return merge(left,right);
    }
      
      static int [] merge(int [] a, int[] b) {
        int [] ret = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (j < a.length && k < b.length) {
          if (a[j] < b[k]) {
            ret[i++] = a[j++];
          } else {
            ret[i++] = a[j++];
          }
        }
        while (j < a.length) {
          ret[i++] = a[j++];
        }
        while (k < b.length) {
          ret[i++] = b[j++];
        }
      }
      
       static int [] subArr(int [] arr, int start, int end) {
         int [] ret = new int [end-start];
         for (int i = 0; i < end-start; i++) {
           ret[i] = arr[start + i];
         }
     }
  } 





    //pseudocode 
 	/*int [] arr = {1,4,6,8,7,3,2,9};   
    mergesort(array a) 
      if(n == 1) {
        return a;
        arrayOne = a[0]...a[n/2]
        arrayTwo = a[n/1]...a[n]
        arrayOne = mergesort(arrayOne)
        arrayTwo = mergesort(arrayTwo)
        return merge(arrayOne,arrayTwo)
       */

