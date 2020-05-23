class connectSiblings{
  public static void populate_sibling_pointers(BinaryTreeNode root) {
    if (root == null){
      return;
    }
    
    root.next = null;
    
    do {
      root = connectNextLevel(root);
    } while (root != null);
  }
  
  public static BinaryTreeNode connectNextLevel(BinaryTreeNode head){
    BinaryTreeNode current = head;
    BinaryTreeNode nextLevelHead = null;
    BinaryTreeNode prev = null;
    
    while(current != null){
      if (current.left != null && current.right != null){
        
        if (nextLevelHead == null){
          nextLevelHead = current.left;
        }
        
        current.left.next = current.right;
        
        if (prev != null){
          prev.next = current.left;
        }
        
        prev = current.right;
      } else if (current.left != null){
        
        if (nextLevelHead == null){
          nextLevelHead = current.left;
        }
        
        if(prev != null){
          prev.next = current.left;
        }
        
        prev = current.left;
      } else if (current.right != null){
        
        if (nextLevelHead == null){
          nextLevelHead = current.right;
        }
        
        if (prev != null){
          prev.next = current.right;
        }
        
        prev = current.right;
      }
      
      current = current.next;
    }
    if (prev != null){
      prev.next = null;
    }
    
    return nextLevelHead;
  }     
}  