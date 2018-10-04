package com.company;

/*
This problem was asked by Google.

A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:

   0
  / \
 1   0
    / \
   1   0
  / \
 1   1


*/


public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    /*
    The problem can be solved by divide-and-conquer.
    The only trick is to use different return values to mark different cases.
    Integer.MIN_VALUE -- Mark the subtree is not univaled.
    Integer.MAX_VALUE -- Mark if the root is null.
     */


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }

        countUnivalSubtreesHelper(root);

        return count;
    }

    public int countUnivalSubtreesHelper(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        // Divide
        int left = countUnivalSubtreesHelper(root.left);
        int right = countUnivalSubtreesHelper(root.right);

        // left and right are all empty
        if (left == Integer.MAX_VALUE && right == Integer.MAX_VALUE) {
            count++;
            return root.val;
        } else if (left == Integer.MAX_VALUE || right == Integer.MAX_VALUE) {
            if (root.val == left || root.val == right) {
                count++;
                return root.val;
            } else {
                return Integer.MIN_VALUE;
            }
        } else {
            if (root.val == left && root.val == right) {
                count++;
                return root.val;
            } else {
                return Integer.MIN_VALUE;
            }
        }
    }
}
