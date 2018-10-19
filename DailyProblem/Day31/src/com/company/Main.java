package com.company;

/*
This problem was asked by Google.

The edit distance between two strings refers to the minimum number of character insertions,
deletions, and substitutions required to change one string to the other. For example,
the edit distance between “kitten” and “sitting” is three: substitute the “k” for “s”,
substitute the “e” for “i”, and append a “g”.

Given two strings, compute the edit distance between them.
*/

//o(n^2) time and space

public class Main {

    public static void main(String[] args) {
        System.out.println(levenshtein_distance("kitten", "sitting"));
    }

    public static int minimum(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }

    public static int levenshtein_distance(String str1, String str2){
        if (str1.equals(str2)){
            return 0;
        }

        if (str1.length() == 0){
            return str2.length();
        }

        if (str2.length() == 0){
            return str1.length();
        }

        int[] d1 = new int[str2.length()+1];
        int[] d2 = new int[str2.length()+1];

        for (int i=0; i<d1.length; i++){
            d1[i] = i;
        }

        int cost;
        for (int i=0; i<str1.length(); i++){
            d2[0] = i+1;

            for (int j=0; j<str2.length(); j++){

                if (str1.charAt(i) == str2.charAt(j)){
                    cost = 0;
                } else {
                    cost = 1;
                }

                d2[j + 1] = minimum(d2[j] + 1, d1[j + 1] + 1, d1[j] + cost);
            }

            for (int j=0; j<d1.length; j++){
                d1[j] = d2[j];
            }

        }

        return d2[str2.length()];

    }
}
