class inorderSuccessor{
  
  static BinaryTreeNode findMin (BinaryTreeNode node){
    if (node == null){
      return null;
    }
    
    if (node.left != null){
      node = node.left;
    }
    
    return node;
  }
  
  static BinaryTreeNode inorder_successor_bst(
      BinaryTreeNode root,
      int d) {
    
    if (root == null) {
      return null;
    }
    
    BinaryTreeNode sucessor = null;
    
    while (root != null){
      if (root.data < d){
        root = root.right;
      } else if (root.data > d){
        sucessor = root;
        root = root.left;
      } else {
        if (root.right != null){
          sucessor = findMin(root.right);
        }
        break;
      }
    }
    
    return sucessor;
  }
}  