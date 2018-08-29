import java.io.*;
import java.util.*;

class Solution {
  
  static int[] arrayOfArrayProducts(int[] arr) {
    // your code goes here
    
    if (arr.length < 2){
      return new int[0];
    }
    int[] productArray = new int[arr.length];
    
    int productSoFar = 1;
    for (int i=0; i<arr.length; i++){
      productArray[i] = productSoFar;
      productSoFar *= arr[i];
    }
    
    productSoFar = 1;
    for (int i=arr.length-1; i>=0; i--){
      productArray[i] *= productSoFar;
      productSoFar *= arr[i];
    }
    
    return productArray;
  }

  public static void main(String[] args) {

  }

}