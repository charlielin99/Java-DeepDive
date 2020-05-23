class inorderSuccessor{
  static BinaryTreeNode find_successor(BinaryTreeNode root, int d) {
    
    if (root == null){
      return null;
    }
    
    BinaryTreeNode node = root;
    
    while (node != null){
      if (node.data < d){
        node = node.right;
      } else if (node.data > d){
        node = node.left;
      } else {
        return findInOrderParentNode(node);
      }
    }
    
    return null;
  }
  
  static BinaryTreeNode findInOrderParentNode(BinaryTreeNode node){
    
    if (node == null){
      return null;
    }
    
    if (node.right != null){
      return findMinInTree(node.right);
    }
    
    while (node.parent != null){
      if (node.parent.left == node){
        return node.parent;
      }
      node = node.parent;
    }
    
    return null;
  }
  
  static BinaryTreeNode findMinInTree(BinaryTreeNode node){
    if (node == null){
      return null;
    }
    
    while (node.left != null){
      node = node.left;
    }
    
    return node;
  }
}  