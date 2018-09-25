package com.company;

public class Main {

    public static void main(String[] args) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();

        System.out.println("Longest Common Subsequence: " + lcs(x, y));
    }

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