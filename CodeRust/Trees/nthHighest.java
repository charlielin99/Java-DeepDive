class nthHighest{
  public static int current_count = 0;

  public static BinaryTreeNode find_nth_highest_in_bst(BinaryTreeNode node, int n) {
    
    if (node == null){
      return null;
    }
    
    BinaryTreeNode result = find_nth_highest_in_bst(node.right, n);
    
    if (result != null){
      return result;
    }
    
    current_count++;
    
    if (current_count == n){
      return node;
    }
    
    result = find_nth_highest_in_bst(node.left, n);
    
    if (result != null){
      return result;
    }
    
    return null;
  }
}  