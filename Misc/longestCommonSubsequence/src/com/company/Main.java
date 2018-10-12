package com.company;

public class Main {

    public static void main(String[] args) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();

        System.out.println("Longest Common Subsequence: " + lcs(x, y));
    }

    /*
       Following steps build L[m+1][n+1] in bottom up fashion. Note 
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] 

         Time Complexity of the above implementation is O(mn) which is much better than 
         the worst-case time complexity of Naive Recursive implementation


         Let the input sequences be X[0..m-1] and Y[0..n-1] of lengths m and n respectively. And let L(X[0..m-1], Y[0..n-1]) be the length of LCS of the two sequences X and Y. Following is the recursive definition of L(X[0..m-1], Y[0..n-1]).

        If last characters of both sequences match (or X[m-1] == Y[n-1]) then
        L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])

        If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
        L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2]) )
    */

    public static int lcs (char[] x, char[] y){

        int xLength = x.length;
        int yLength = y.length;

        int[][] memo = new int[xLength+1][yLength+1];

        for (int i=0; i<=xLength; i++){
            for (int j=0; j<=yLength; j++){
                if (i == 0 || j == 0){
                    memo[i][j] = 0;
                } else if (x[i-1] == y[j-1]){
                    memo[i][j] = memo[i-1][j-1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
                }
            }
        }

        return memo[xLength][yLength];
    }
}