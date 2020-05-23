package com.company;

/*
This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
*/

public class Main {

    public static void main(String[] args) {
	    int[] test1 = new int[] {1, 2, 3, 4, 5};
        int[] test2 = new int[] {3,2,1};

        int[] result1 = productOfAllExceptIndex(test1);
        int[] result2 = productOfAllExceptIndex(test2);

        for (int print: result1){
            System.out.println(print);
        }

        System.out.println("---");

        for (int print: result2){
            System.out.println(print);
        }
    }

    public static int[] productOfAllExceptIndex(int[] arr){
        int[] result = new int[arr.length];

        int productSofar = 1;

        for (int i=0; i<arr.length; i++){
            result[i] = productSofar;
            productSofar *= arr[i];
        }

        productSofar = 1;

        for (int i=arr.length-1; i>=0; i--){
            result[i] *= productSofar;
            productSofar *= arr[i];
        }

        return result;
    }
}
