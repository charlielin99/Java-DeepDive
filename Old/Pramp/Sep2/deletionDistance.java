import java.io.*;
import java.util.*;

class Solution {

  static int deletionDistance(String str1, String str2) {
    
    int length1 = str1.length();
    int length2 = str2.length();
    
    int[][] memo = new int[length1+1][length2+1];
    
    for(int i=0; i<length2 + 1; i++){
      memo[0][i] = i; 
    }
    
    for (int i=0; i<length1 + 1; i++){
      memo[i][0] = i;
    }
    
    for(int i=1; i<length1 + 1; i++) {
        for(int j=1; j<length2 + 1; j++) {
          char char1 = str1.charAt(i-1); 
          char char2 = str2.charAt(j-1); 
          boolean isEqual = char1 == char2; 
          
          if(isEqual) {
            memo[i][j] = memo[i-1][j-1];
          } else {
            memo[i][j] = 1 + Math.min(memo[i-1][j], memo[i][j-1]); 
          }
        }
      }
      return memo[length1][length2];  
  }

  public static void main(String[] args) {

  }

}