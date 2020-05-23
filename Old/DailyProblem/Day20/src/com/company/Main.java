package com.company;

/*
This problem was asked by Google.

Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.

Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.

*/

public class Main {

    public class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
	// write your code here
    }

    public static int getLength(LinkedListNode head){
        int length = 0;
        while (head != null){
            head = head.next;
            length++;
        }
        return length;
    }

    public static LinkedListNode intersect(
            LinkedListNode head1,
            LinkedListNode head2) {

        LinkedListNode list1;
        LinkedListNode list2;
        int head1Length = getLength(head1);
        int head2Length = getLength(head2);
        int lengthDiff = 0;

        if (head1Length >= head2Length){
            lengthDiff = head1Length - head2Length;
            list1 = head1;
            list2 = head2;
        } else {
            lengthDiff = head2Length - head1Length;
            list1 = head2;
            list2 = head1;
        }

        while (lengthDiff > 0){
            list1 = list1.next;
            lengthDiff--;
        }

        while (list1 != null){
            if (list1 == list2){
                return list1;
            }
            list1 = list1.next;
            list2 = list2.next;
        }

        return null;
    }
}
