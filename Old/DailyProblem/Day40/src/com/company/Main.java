package com.company;

/*
This problem was asked by Google.

Given an array of integers where every integer occurs three times except for one integer,
which only occurs once, find and return the non-duplicated integer.

For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in O(N) time and O(1) space.
*/

public class Main {

    public static void main(String[] args) {
	    int[] arr = new int[] {6, 1, 3, 3, 3, 6, 6};
        System.out.println(getSingle(arr));
    }

    /*
    time: O(n)
    space: O(1)

    We can sum the bits in same positions for all the numbers and take modulo with 3.
    The bits for which sum is not multiple of 3, are the bits of number with single occurrence.

    Let us consider the example array {5, 5, 5, 8}. The 101, 101, 101, 1000
    Sum of first bits%3 = (1 + 1 + 1 + 0)%3 = 0;
    Sum of second bits%3 = (0 + 0 + 0 + 0)%0 = 0;
    Sum of third bits%3 = (1 + 1 + 1 + 0)%3 = 0;
    Sum of fourth bits%3 = (1)%3 = 1;
    Hence number which appears once is 1000
    */

    // Method to find the element that occur only once
    static int getSingle(int arr[]) {
        int result = 0;
        int x, sum;

        // Iterate through every bit
        // 32 because that is size of integer for bits
        for(int i=0; i< 32; i++) {
            // Find sum of set bits at ith position in all
            // array elements
            sum = 0;
            x = (1 << i);
            for(int j=0; j<arr.length; j++)
            {
                if((arr[j] & x) == 0)
                    sum++;
            }
            // The bits with sum not multiple of 3, are the
            // bits of element with single occurrence.
            if ((sum % 3) == 0){
                result |= x;
            }

        }
        return result;
    }

}
