package com.company;

import java.util.Arrays;

/*
Sort the array first.
Start fixing the greatest element of three from back and traverse the array to find other
two numbers which sum upto the third element.
Time complexity : O(n^2)
 */

public class GFG {

    // utility function for finding
    // triplet in array
    static void findTriplet(int arr[], int n)
    {
        // sort the array
        Arrays.sort(arr);

        // for every element in arr
        // check if a pair exist(in array) whose
        // sum is equal to arr element
        for (int i = n - 1; i >= 0; i--) {
            int j = 0;
            int k = i - 1;
            while (j < k) {
                if (arr[i] == arr[j] + arr[k]) {

                    // pair found
                    System.out.println("numbers are " + arr[i] + " "
                            + arr[j] + " " + arr[k]);

                    return;
                } else if (arr[i] > arr[j] + arr[k])
                    j += 1;
                else
                    k -= 1;
            }
        }

        // no such triplet is found in array
        System.out.println("No such triplet exists");
    }

    // driver program
    public static void main(String args[])
    {
        int arr[] = { 5, 32, 1, 7, 10, 50, 19, 21, 2 };
        int n = arr.length;
        findTriplet(arr, n);
    }
}
