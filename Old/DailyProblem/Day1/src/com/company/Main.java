package com.company;

/*
This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
*/

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	    int[] arr = new int[] {10, 15, 3, 7};
	    int sum = 17;

        System.out.println(twoSum(arr, sum));
    }

    public static boolean twoSum (int[] arr, int sum){
        Set<Integer> set = new HashSet<Integer>();
        for (int current: arr){
            if (set.contains(sum-current)){
                return true;
            }
            set.add(current);
        }
        return false;
    }
}
