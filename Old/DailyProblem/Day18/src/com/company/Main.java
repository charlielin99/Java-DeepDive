package com.company;

/*
This problem was asked by Google.

Given an array of integers and a number k, where 1 <= k <= length of the array,
compute the maximum values of each subarray of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)
Do this in O(n) time and O(k) space.
You can modify the input array in-place and you do not need to store the results.
You can simply print them out as you compute them.

 */

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	    int[] temp = new int[] {10, 5, 2, 7, 8, 7};
	    int[] res = maxSlidingWindow(temp, 3);
	    for(int s: res){
            System.out.println(s);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (k == 0){
            return new int[0];
        }

        int[] result = new int [nums.length - k + 1];
        int resultCounter = 0;
        LinkedList<Integer> storage = new LinkedList<>();

        for (int i=0; i<k; i++){
            while (!storage.isEmpty() && nums[storage.peekLast()] <= nums[i]){
                storage.removeLast();
            }
            storage.addLast(i);
        }

        result[resultCounter++] = nums[storage.peekFirst()];

        for (int i=k; i<nums.length; i++){
            if (!storage.isEmpty() && storage.peekFirst() <= i - k){
                storage.removeFirst();
            }
            while (!storage.isEmpty() && nums[storage.peekLast()] <= nums[i]){
                storage.removeLast();
            }

            storage.addLast(i);
            result[resultCounter++] = nums[storage.peekFirst()];
        }

        return result;
    }
}
