package com.company;

/*
This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space.
In other words, find the lowest positive integer that does not exist in the array.
The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.
*/

public class Main {

    public static void main(String[] args) {
        System.out.println(findMissing(new int[] {0, 10, 2, -10, -20}));
        System.out.println(findMissing(new int[] {3, 4, -1, 1}));
        System.out.println(findMissing(new int[] {1, 2, 0}));
    }

    public static int findMissing(int[] arr){
        int shift = segragateSign(arr);
        int newSize = arr.length - shift;

        for(int i = shift; i <arr.length; i++) {
            int index = Math.abs(arr[i]);
            if(index-1+shift < arr.length && arr[index-1+shift] > 0)
                arr[index-1+shift] = -arr[index-1+shift];
        }
        for(int i = shift; i < arr.length; i++) {
            if(arr[i] > 0)
                return i-shift+1;
        }
        return newSize+1;
    }

    public static int segragateSign(int[] arr){
        int j=0;
        for (int i=0; i<arr.length; i++){
            if (arr[i] <= 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j++] = temp;
            }
        }

        return j;
    }
}
