class mirrorBT{
  public static void mirror_binary_tree(BinaryTreeNode root) {
    
    if (root == null){
      return;
    }
    
    if (root.left != null){
      mirror_binary_tree(root.left);
    }
    
    if (root.right != null){
      mirror_binary_tree(root.right);
    }
    
    BinaryTreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
  }
}  