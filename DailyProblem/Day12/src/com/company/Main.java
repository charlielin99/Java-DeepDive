package com.company;

/*
This problem was asked by Amazon.

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
Given N, write a function that returns the number of unique ways you can climb the staircase.
The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2
What if, instead of being able to climb 1 or 2 steps at a time,
you could climb any number from a set of positive integers X?
For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.

*/

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        System.out.println(scoringOptions(4, arr));
    }

    public static int scoringOptions(int n, int[] arr) {
        if(n <= 0)
            return 0;

        Arrays.sort(arr);

        int[] result = new int[n];

        //save the base case on last index of the array
        result[n-1] = 1;


        for(int i=1; i <= n; i++) {
            int sum = 0;
            for (int num : arr) {
                sum += result[n - num];
            }

            for (int j = 0; j < n-1; j++) {
                result[j] = result[j+1];
            }
            result[n - 1] = sum;
        }

        return result[n-1];
    }
}
