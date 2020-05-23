package com.company;

/*
This problem was asked by Airbnb.

Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

Follow-up: Can you do this in O(N) time and constant space?
*/

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,6,2,5};
        System.out.println(find_max_sum_nonadjacent(arr));
        int[] arr2 = new int[]{5,1,1,5};
        System.out.println(find_max_sum_nonadjacent(arr2));
    }


    static int find_max_sum_nonadjacent(int[] a) {
        if (a == null || a.length == 0){
            return 0;
        }

        if (a.length == 1){
            return a[0];
        }

        int[] result = new int[a.length];
        result[0] = a[0];

        for (int i=1; i<a.length; i++){
            result[i] = Math.max(a[i], result[i-1]);

            if (i-2 >= 0){
                result[i] = Math.max(result[i], a[i] + result[i-2]);
            }
        }

        return result[a.length -1];
    }
}
