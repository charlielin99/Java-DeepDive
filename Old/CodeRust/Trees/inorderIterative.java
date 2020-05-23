class inorderIterative{
  static String inorder_iterative(BinaryTreeNode root)
  {
    String result = "";
    if (root == null){
      return result;
    }
    
    Deque<BinaryTreeNode> stack = new ArrayDeque<>();
    
    while (!stack.isEmpty() || root != null){
      
      while (root != null){
        stack.push(root);
        root = root.left;
      }
      
      result += stack.peek().data + ",";
      root = stack.pop().right;
    }
    
    return result;
  }   
}  