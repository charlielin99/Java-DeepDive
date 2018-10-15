package com.company;

/*
This problem was asked by Google.

Given a singly linked list and an integer k, remove the kth last element from the list.
k is guaranteed to be smaller than the length of the list.

The list is very long, so making more than one pass is prohibitively expensive.

Do this in constant space and in one pass.

*/

public class Main {

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode kthToLastNode(int k, LinkedListNode head) {

        LinkedListNode leftNode  = head;
        LinkedListNode rightNode = head;

        // move rightNode to the kth node
        for (int i = 0; i < k - 1; i++) {
            rightNode = rightNode.next;
        }

        // starting with leftNode on the head,
        // move leftNode and rightNode down the list,
        // maintaining a distance of k between them,
        // until rightNode hits the end of the list
        while (rightNode.next != null) {
            leftNode  = leftNode.next;
            rightNode = rightNode.next;
        }

        // since leftNode is k nodes behind rightNode,
        // leftNode is now the kth to last node!
        leftNode.value = leftNode.next.value;
        leftNode.next = leftNode.next.next;

        return head;
    }

    public static void main(String[] args) {
	// write your code here
    }
}
