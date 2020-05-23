package com.company;

/*

This problem was asked by Twitter.

You run an e-commerce website and want to record the last N order ids in a log.
Implement a data structure to accomplish this, with the following API:

record(order_id): adds the order_id to the log
get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.

You should be as efficient with time and space as possible.
 */


// Circular array
// Append and access like a normal array except everything is mod n
// And when you access add an offset


public class Main {

    public static void main(String[] args) {
	    CircularArray cir = new CircularArray(6);
	    cir.record(1);
	    cir.record(2);
	    cir.record(3);
	    cir.record(4);
	    cir.record(5);
	    cir.record(6);
	    cir.record(20);

        System.out.println(cir.get_last(1));
    }

    private static class CircularArray {
        int[] arr;
        int arrCounter;

        CircularArray(int n){
            arr = new int[n];
            arrCounter = 0;
        }

        void record (int order_id){
            arr[arrCounter++ % arr.length] = order_id;
        }

        int get_last (int i){
            int access = arrCounter - i;
            return arr[access % arr.length];
        }
    }
}
