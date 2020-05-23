/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//time: o(n)
//space: o(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(root.val > p.val && root.val > q.val)
                root = root.left;
            else if ( root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }   
        return root;
    }
}