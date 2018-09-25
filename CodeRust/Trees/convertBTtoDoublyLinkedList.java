class toDLL{
  public static BinaryTreeNode convert_to_linked_list(
      BinaryTreeNode root) {
    
    if (root == null){
      return null;
    }
    
    BinaryTreeNode list1 = convert_to_linked_list(root.left);
    BinaryTreeNode list2 = convert_to_linked_list(root.right);
    
    root.left = root.right = root;
    
    BinaryTreeNode result = concatanate(list1, root);
    result = concatanate(result, list2);
    
    return result;
  }
  
  public static BinaryTreeNode concatanate(BinaryTreeNode head1, BinaryTreeNode head2){
    if (head1 == null){
      return head2;
    }
    
    if (head2 == null){
      return head1;
    }
    
    BinaryTreeNode tail1 = head1.left;
    BinaryTreeNode tail2 = head2.left;
    
    tail1.right = head2;
    head2.left = tail1;
    
    head1.left = tail2;
    tail2.right = head1;
    
    return head1;
  } 
}  