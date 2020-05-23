class delZeroSum{
  public static void delete_zero_sum_subtree(BinaryTree tree) {
    
    if (tree == null || tree.root == null) {
      return;
    }
    
    if (deleteZeroRecursive(tree.root) == 0){
      tree.root = null;
    }
  }
  
  public static int deleteZeroRecursive(BinaryTreeNode node){
    if (node == null){
      return 0;
    }
    
    int leftTreeSum = deleteZeroRecursive(node.left);
    int rightTreeSum = deleteZeroRecursive(node.right);
    
    if (leftTreeSum == 0){
      node.left = null;
    }
    
    if (rightTreeSum == 0){
      node.right = null;
    }
    
    return node.data + leftTreeSum + rightTreeSum;
  }
}  