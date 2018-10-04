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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }



    //CACHEING

    /*
     public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> mapIndex = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            mapIndex.put(inorder[i],i);
        }
        return buildFromPreorderInorder(preorder,0,inorder,0,inorder.length -1, mapIndex);
    }

    // id - inStart is the left sub tree's size, end - id is the right sub tree's size
    private TreeNode buildFromPreorderInorder(int[] preorder,int preId, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> map )
    {
       if(inStart > inEnd)return null;
        int val = preorder[preId];
        int id = map.get(val);  // the divider's index
        TreeNode root = new TreeNode(val);
        root.left = buildFromPreorderInorder(preorder,preId +1, inorder, inStart, id -1, map);
        root.right = buildFromPreorderInorder(preorder,preId + id - inStart +1 , inorder, id +1, inEnd, map);

        return root;
    }
    */
}