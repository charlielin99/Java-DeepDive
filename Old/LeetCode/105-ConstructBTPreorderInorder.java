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
/*The basic idea is here:
Say we have 2 arrays, PRE and IN.
Preorder traversing implies that PRE[0] is the root node.
Then we can find this PRE[0] in IN, say it's IN[5].
Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
Recursively doing this on subarrays, we can build a tree out of it :)

Space: O(N)
Because each node we create a helper(), the recursion stack will cost O(N)

Time: O(N log N) for a balanced tree, O(N^2) for a skew tree
As mentioned above, the helper() runs O(N) time, and for each helper(), there is a for-loop to search the inorder index.

For a balanced tree, the range of the search will be reduced by half each time, so the search costs O(log n)
Therefore the time is O(N) * O(log N) = O(N log N)

For a skew tree, the range of the search will only be reduced by 1, so the search still costs O(N)
Therefore the time is O(N) * O(N) = O(N^2)

*/

 public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder.length!=inorder.length) return null;
    return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
}

public TreeNode buildTree(int [] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh){
    if(preLow>preHigh || inLow>inHigh) return null;
    TreeNode root = new TreeNode(preorder[preLow]);
   
    int inorderRoot = inLow;
    for(int i=inLow;i<=inHigh;i++){
        if(inorder[i]==root.val){ inorderRoot=i; break; }
    }
   
    int leftTreeLen = inorderRoot-inLow;
    root.left = buildTree(preorder, preLow+1, preLow+leftTreeLen, inorder, inLow, inorderRoot-1);
    root.right = buildTree(preorder, preLow+leftTreeLen+1, preHigh, inorder, inorderRoot+1, preHigh);       
    return root;        
}
}