package com.company;

/*
This problem was asked by Microsoft.

Compute the running median of a sequence of numbers. That is, given a stream of numbers,
print out the median of the list so far on each new element.

Recall that the median of an even-numbered list is the average of the two middle numbers.

For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:

2
1.5
2
3.5
2
2
2

*/

import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	    MedianFinder finder = new MedianFinder();
	    finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(1);
        System.out.println(finder.findMedian());
        finder.addNum(5);
        System.out.println(finder.findMedian());
        finder.addNum(7);
        System.out.println(finder.findMedian());
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(0);
        System.out.println(finder.findMedian());
        finder.addNum(5);
        System.out.println(finder.findMedian());

    }

    private static class MedianFinder {

    /*
    min queue holds the larger elements of the stream with the ability to provide the least element in it in O(1)
    max queue holds the smaller elements of the stream with the ability to provide the largest element in it in O(1)

    time O(lgn) - add operation
    space o(n) - entire input stream

    */

        // max queue is always larger or equal to min queue
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        // Adds a number into the data structure.
        public void addNum(int num) {
            max.offer(num);
            min.offer(max.poll());
            if (max.size() < min.size()){
                max.offer(min.poll());
            }
        }

        // Returns the median of current data stream
        public double findMedian() {
            if (max.size() == min.size()) return (max.peek() + min.peek()) /  2.0;
            else return max.peek();
        }
    }


}
