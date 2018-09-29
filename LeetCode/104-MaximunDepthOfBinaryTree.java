/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        
        if (root == null){
            return 0;
        }
        
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> depths = new ArrayDeque<>();
        nodes.push(root);
        depths.push(1);
        int max = 0;
        
        while(!nodes.isEmpty()){
            TreeNode node = nodes.pop();
            int depth = depths.pop();
            max = Math.max(max, depth);
            
            if (node.right != null){
                nodes.push(node.right);
                depths.push(depth+1);
            }
            if (node.left != null){
                nodes.push(node.left);
                depths.push(depth+1);
            }
        }
        
        return max;
        
    }
}