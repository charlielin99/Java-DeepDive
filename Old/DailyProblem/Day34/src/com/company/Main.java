package com.company;

/*
This problem was asked by Quora.

Given a string, find the palindrome that can be made by inserting the fewest number of characters as
possible anywhere in the word. If there is more than one palindrome of minimum length that can be made,
return the lexicographically earliest one (the first one alphabetically).

For example, given the string "race", you should return "ecarace", since we can add three letters
to it (which is the smallest amount to make a palindrome). There are seven other palindromes that can
be made from "race" by adding three letters, but "ecarace" comes first alphabetically.

As another example, given the string "google", you should return "elgoogle".
*/

public class Main {

    /*
    The problem of finding minimum insertions can also be solved using Longest Common Subsequence (LCS) Problem.
    If we find out LCS of string and its reverse, we know how many maximum characters can form a palindrome.
    We need insert remaining characters. Following are the steps.
     */

    public static void main(String[] args) {
        System.out.println(findMinInsertionsLCS("google"));
    }

    // Returns length of LCS for X[0..m-1], Y[0..n-1]. http://goo.gl/bHQVP
    static int lcs( String X, String Y, int m, int n ) {
        int L[][] = new int[n+1][n+1];
        int i, j;

        // Following steps build L[m+1][n+1] in bottom up fashion. Note that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
        for (i=0; i<=m; i++) {
            for (j=0; j<=n; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (X.charAt(i-1) == Y.charAt(j-1)) {
                    L[i][j] = L[i-1][j-1] + 1;
                } else {
                    L[i][j] = Integer.max(L[i-1][j], L[i][j-1]);
                }
            }
        }

        // L[m][n] contains length of LCS for X[0..n-1] and Y[0..m-1]
        return L[m][n];
    }

    // LCS based function to find minimum number of insersions
    static int findMinInsertionsLCS(String str) {
        // Using StringBuffer to reverse a String
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        String revString = sb.toString();

        int n = str.length();

        // The output is length of string minus
        // length of lcs of str and it reverse
        return (n - lcs(str, revString , n, n));
    }

}
