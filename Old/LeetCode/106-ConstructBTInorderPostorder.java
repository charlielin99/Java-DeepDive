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
Space: O(N)
Because each node we create a helper(), the recursion stack will cost O(N)

Time: O(N log N) for a balanced tree, O(N^2) for a skew tree
As mentioned above, the helper() runs O(N) time, and for each helper(), there is a for-loop to search the inorder index.

For a balanced tree, the range of the search will be reduced by half each time, so the search costs O(log n)
Therefore the time is O(N) * O(log N) = O(N log N)

For a skew tree, the range of the search will only be reduced by 1, so the search still costs O(N)
Therefore the time is O(N) * O(N) = O(N^2)
*/
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length!=inorder.length) return null;
        return buildTree(inorder, inorder.length-1, 0, postorder, postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int inLow, int inHigh, int[] postorder,
		int postLow) {
	    if (postLow < 0 || inLow < inHigh)
		    return null;
	
	    //The last element in postorder is the root.
	    TreeNode root = new TreeNode(postorder[postLow]);
	
	    //find the index of the root from inorder. Iterating from the end.
	    int rIndex = inLow;
	    for (int i = inLow; i >= inHigh; i--) {
		    if (inorder[i] == postorder[postLow]) {
			    rIndex = i;
			    break;
		    }
	    }
	    //build right and left subtrees. Again, scanning from the end to find the sections.
	    root.right = buildTree(inorder, inLow, rIndex + 1, postorder, postLow-1);
	    root.left = buildTree(inorder, rIndex - 1, inHigh, postorder, postLow - (inLow - rIndex) -1);
	    return root;
    }
}