package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

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

    public static class NodeDepthPair {
        BinaryTreeNode node;
        int depth;

        public NodeDepthPair(BinaryTreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }


    NodeDepthPair findDeepest(BinaryTreeNode root) {
        Deque<BinaryTreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> depthStack = new ArrayDeque<>();

        nodeStack.add(root);
        depthStack.add(0);

        BinaryTreeNode curr, maxNode = root;
        Integer currDepth, maxDepth = 0;

        while(!nodeStack.isEmpty()) {
            curr = nodeStack.pop();
            currDepth = depthStack.pop();

            if (curr != null) {
                if (currDepth > maxDepth) {
                    maxNode = curr;
                    maxDepth = currDepth;
                }

                nodeStack.push(curr.left);
                depthStack.push(currDepth + 1);
                nodeStack.push(curr.right);
                depthStack.push(currDepth + 1);
            }
        }

        return new NodeDepthPair(maxNode, maxDepth);
    }

    public static void main (String[] args){
        System.out.println("Should I test this");
    }
}
