package Labs;

import java.util.*;
class Lab4_sortingAlgorithims {
  public static void main(String[] args) {
    int [] arr = initRandomArray(20);
    System.out.println("Initial array: ");
    System.out.println(Arrays.toString(arr));
    
    yourSort(arr);

    System.out.println("\n After sorting: ");
    System.out.println(Arrays.toString(arr));
  }

  public static void yourSort(int [] a) {
      int lastSwap = a.length - 1;
    for (int i = 1; i < a.length; i++) {
        boolean is_sorted = true;
        int currentSwap = -1;
        for (int j = 0; j < lastSwap; j++) {
            if (a[j] > a[j + 1]) {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
                is_sorted = false;
                currentSwap = j;
            }
        }
        if (is_sorted) return;
        lastSwap = currentSwap;
    }
  }
  
  
  public static int [] initRandomArray(int len) {
    int [] arr = new int[len];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random()*100);
    }
    return arr;
  }
}


