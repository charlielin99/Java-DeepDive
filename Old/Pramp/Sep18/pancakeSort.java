import java.io.*;
import java.util.*;

class Solution {
  
  static void flip(int[] arr, int k){
    int left = 0;
    int right = k;
    
    while (left < right){
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
    
  }

  static int[] pancakeSort(int[] arr) {
      
    return pancakeSort(arr, arr.length);
    
  }
  
  static int[] pancakeSort(int[] arr, int length){
    
    if (length == 0){
      return arr;
    }
    
    int max = Integer.MIN_VALUE;
    int maxIndex = 0;
    
    for (int i=0; i<length; i++){
      if (arr[i] > max){
        max = arr[i];
        maxIndex = i;
      }
    }
    
    flip(arr, maxIndex);
    flip(arr, length - 1);
    
    return pancakeSort(arr, length - 1); 
    
  }

  public static void main(String[] args) {

  }

}