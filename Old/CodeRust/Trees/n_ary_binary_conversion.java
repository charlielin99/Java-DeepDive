class n_ary_binary_conversion {
  public static BinaryTreeNode convert_n_ary_to_binary(
      TreeNode root) {
    return convertNaryToBinaryRecursive(root, true);
  }
  
  public static BinaryTreeNode convertNaryToBinaryRecursive(TreeNode root, boolean isLeft){
    if (root == null){
      return null;
    }
    
    BinaryTreeNode node = new BinaryTreeNode(root.data);
    BinaryTreeNode lastNode = node;
    
    for (int i=0; i<root.Children.size(); i++){
      if (isLeft){
        lastNode.left = convertNaryToBinaryRecursive(root.Children.get(i), !isLeft);
        lastNode = lastNode.left;
      } else {
        lastNode.right = convertNaryToBinaryRecursive(root.Children.get(i), !isLeft);
        lastNode = lastNode.right;
      }
    }
    
    return node;
  }
        

  public static TreeNode convert_binary_to_n_ary_tree(
      BinaryTreeNode root) {
    
    return convertBinaryToNaryRecursive(root, true);
  }
  
  public static TreeNode convertBinaryToNaryRecursive(BinaryTreeNode root, boolean isLeft){
    
    TreeNode nnode = new TreeNode(root.data);
    BinaryTreeNode temp = root;
    
    if (isLeft){
      while (temp.left != null){
        TreeNode child = convertBinaryToNaryRecursive(temp.left, !isLeft);
        nnode.Children.add(child);
        temp = temp.left;
      }
    } else {
      while (temp.right != null){
        TreeNode child = convertBinaryToNaryRecursive(temp.right, !isLeft);
        nnode.Children.add(child);
        temp = temp.right;
      }
    }
    
    return nnode;
  }
}  