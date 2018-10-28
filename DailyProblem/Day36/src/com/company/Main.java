package com.company;

/*
This problem was asked by Dropbox.

Given the root to a binary search tree, find the second largest node in the tree.
*/

public class Main {

    /*
    We're doing one walk down our BST, which means O(h) time,
    where h is the height of the tree (again, that's O(lgn) if the tree is balanced, O(n) otherwise).
    O(1) space.

    */

    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }

    public static int findLargest(BinaryTreeNode rootNode){
        BinaryTreeNode current = rootNode;
        while (current.right != null){
            current = current.right;
        }
        return current.value;
    }

    public static int findSecondLargest(BinaryTreeNode rootNode) {

        // find the second largest item in the binary search tree
        if (rootNode == null || (rootNode.right == null && rootNode.left == null)){
            throw new IllegalArgumentException("Need at least 2 nodes");
        }

        BinaryTreeNode current = rootNode;

        while (true){
            if (current.right == null && current.left!= null){
                return findLargest(current.left);
            }

            if (current.right!= null && current.right.right == null && current.right.left == null){
                return current.value;
            }

            if (current.right != null){
                current = current.right;
            }
        }
    }


    public static void main(String[] args) {
	// write your code here
    }


}
