package com.company;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	    int [] temp = new int[] {2,45,7,3,5,1,8,9};
	    numberPairsForSum(temp, 10);
    }

    public static void numberPairsForSum(int[] array, int sum) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : array) {
            if (set.contains(sum - num)) {
                String s = num + ", " + (sum - num) + " add up to " + sum;
                System.out.println(s);
            }
            set.add(num);
        }
    }
}
