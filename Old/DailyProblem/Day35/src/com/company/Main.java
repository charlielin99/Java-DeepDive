package com.company;

/*
This problem was asked by Google.

Given an array of strictly the characters 'R', 'G', and 'B',
segregate the values of the array so that all the Rs come first,
the Gs come second, and the Bs come last. You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'],
it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
*/

public class Main {

    public static void main(String[] args) {
	    char[] arr = new char[] {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
	    sortColors(arr);
	    for (char c: arr){
            System.out.println(c);
        }
    }

    // straightforward solution is to use a 2 pass counting sort
    // this will take o(n) space though

    // here is a one pass in constant space!
    // 1-pass is essentially the 3-way quick partition method in quicksort
    // o(n) time
    // there are only 3 elements so 3 way partition works perfectly

    /*
    quicksort 3-way partition
    +------+---------+-------------+-------+
    |  <p  |  =p     |  unseen .  |   > p  |
    +------+---------+------------+-------+
            ↑          ↑           ↑
          pivot      first        last
    pivot: 1st elem == pivot
    unseenFirst:  1st unseen elem
    unseenLast: last unseen elem
    */

    public static void sortColors(char[] nums) {
        int pivot = 0;
        int unseenFirst = 0;
        int unseenLast = nums.length - 1;

        while (unseenFirst <= unseenLast) {
            if (nums[unseenFirst] == 'R') {
                swap(nums, pivot++, unseenFirst++);
            } else if (nums[unseenFirst] == 'B') {
                swap(nums, unseenFirst, unseenLast--);
            } else { // nums[unseenFirst] == 'G'
                unseenFirst++;
            }
        }
    }
    public static void swap(char[] nums, int p1, int p2) {
        char temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}
