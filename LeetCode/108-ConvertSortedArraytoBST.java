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
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1){
            return null;
        }
        TreeNode head = helper(nums, 0, nums.length - 1);
        return head; 
    }
    
    public TreeNode helper(int[] nums, int left, int right){
        if (left > right){
            return null;
        }
        
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);
        
        return node;
    }
    
}