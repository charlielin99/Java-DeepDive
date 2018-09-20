class isBST{
  public static boolean is_bst(
      BinaryTreeNode root) {
    return is_bst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  public static boolean is_bst(BinaryTreeNode root, int lowerBound, int upperBound){
    if (root == null){
      return true;
    }
    
    if (root.data < lowerBound || root.data > upperBound){
      return false;
    }
    
    return is_bst(root.left, lowerBound, root.data) && is_bst(root.right, root.data, upperBound);
  }
}