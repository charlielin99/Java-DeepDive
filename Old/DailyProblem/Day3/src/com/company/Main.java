package com.company;

/*

This problem was asked by Google.

Given the root to a binary tree, implement serialize(root),
which serializes the tree into a string, and deserialize(s),
which deserializes the string back into the tree.
*/


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

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

    private static final int MARKER = Integer.MIN_VALUE;

    public static void serialize(BinaryTreeNode node, ObjectOutputStream stream) throws java.io.IOException{
        if (node == null){
            stream.writeInt(MARKER);
        }

        stream.writeInt(node.value);
        serialize(node.left, stream);
        serialize(node.right, stream);
    }

    public static BinaryTreeNode deserialize(ObjectInputStream stream) throws java.io.IOException {
        int val = stream.readInt();

        if (val == MARKER) {
            return null;
        }

        BinaryTreeNode node = new BinaryTreeNode(val);
        node.left = deserialize(stream);
        node.right = deserialize(stream);

        return node;
    }


    public static void main(String[] args) {
	// write your code here
    }
}
