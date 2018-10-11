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
pre-order traversal is root-left-right, and post order is left-right-root. modify the code for pre-order to make it root-right-left, and then reverse the output so that we can get left-right-root .

Create an empty stack, Push root node to the stack.
Do following while stack is not empty.
2.1. pop an item from the stack and print it.

2.2. push the left child of popped item to stack.

2.3. push the right child of popped item to stack.

reverse the ouput.
*/
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        
        if (root == null) return ret;
        
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            ret.add(0, curr.val);
            if (curr.left != null)
                stack.push(curr.left);
            if (curr.right != null)
                stack.push(curr.right);
        }
        
        return ret;
    }
}

/*
Alternate Less Hacky Solution (no pre-order) with 2 stacks:

public List<Integer> postorderTraversal(TreeNode root) {
  List<Integer> res = new ArrayList<Integer>();
  
  if (root == null)
    return res;
      
  Stack<TreeNode> s1 = new Stack<TreeNode>();
  Stack<TreeNode> s2 = new Stack<TreeNode>();
  
  s1.push(root);
  
  while (!s1.isEmpty()) {
    TreeNode node = s1.pop();
    s2.push(node);
    
    if (node.left != null)
      s1.push(node.left);
    
    if (node.right != null)
      s1.push(node.right);
  }
  
  while (!s2.isEmpty())
    res.add(s2.pop().val);
  
  return res;
}


*/