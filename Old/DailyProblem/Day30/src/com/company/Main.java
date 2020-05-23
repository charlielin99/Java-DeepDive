package com.company;

/*
This problem was asked by Facebook.

You are given an array of non-negative integers that represents a two-dimensional elevation map where each
element is unit-width wall and the integer is the height. Suppose it will rain and all spots between two walls
get filled up.

Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second,
and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.
*/

public class Main {

    public static void main(String[] args) {
	    int[] arr = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }

    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0, maxleft = 0, maxright = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxleft) {
                    maxleft = height[left];
                } else {
                    res += maxleft - height[left];
                }
                left++;
            }
            else {
                if (height[right] >= maxright) {
                    maxright = height[right];
                } else {
                    res += maxright - height[right];
                }
                right--;
            }
        }
        return res;
    }
}
