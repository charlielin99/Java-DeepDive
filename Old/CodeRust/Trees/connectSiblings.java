class connectSiblings{
    public static void populate_sibling_pointers(BinaryTreeNode root) {
      if (root == null){
        return;
      }
      
      BinaryTreeNode current = root;
      BinaryTreeNode last = root;
      
      while (current != null){
        if (current.left != null){
          last.next = current.left;
          last = last.next;
        }
        if (current.right != null){
          last.next = current.right;
          last = last.next;
        }
        current = current.next;
      }
      
      last.next = null; 
  }
}  