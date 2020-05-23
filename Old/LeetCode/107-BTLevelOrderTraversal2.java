/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
1. Create a list for each level and apply postorder traversal for all nodes at that level
2. Do not rely on level to get the list for that level
3. When recursing, move list for current level from tail to head of the outer list
4. When backtracking, move list for current level from head to tail of the outer list
Complexity: Time - O(n), Space - O(height)
*/
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>(); // LinkedList - addFirst(), add(), remove() and removeLast()
        recursiveLevelOrderBottom(root, 0, result);
        return result;
    }
    
    private void recursiveLevelOrderBottom(TreeNode root, int height, LinkedList<List<Integer>> result) {
        if (root == null) { // Base case
            return;
        }
        
        if (height == result.size()) { // Create a new list for current level
            result.addFirst(new ArrayList<>());
        } else if (height < result.size()) { // Move the list for current level from tail to head
            result.addFirst(result.removeLast());
        }
        
        /* Postorder traversal */
        recursiveLevelOrderBottom(root.left, height + 1, result); // Recursive steps
        recursiveLevelOrderBottom(root.right, height + 1, result);
        // Add root value to the list for current level, then move it from head to tail since we are about to backtrack
        result.peek().add(root.val);
        result.add(result.remove());
    }
}