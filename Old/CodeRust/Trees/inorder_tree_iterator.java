class inorder_tree_iterator {
  
    Deque<BinaryTreeNode> stack = new ArrayDeque<>();

  //TODO: Write - Your - Code
    public inorder_tree_iterator(BinaryTreeNode root) {
      while (root != null){
        stack.push(root);
        root = root.left;
      }
    }

    public boolean hasNext() {
      return !stack.isEmpty();
    }

    public BinaryTreeNode getNext() {
      BinaryTreeNode next = stack.pop();
      BinaryTreeNode temp = next.right;
      while (temp != null){
        stack.push(temp);
        temp = temp.left;
      }
      return next;
    }
  
    //Don't Change anything down below
    public String inorder_using_iterator(BinaryTreeNode root) {
      inorder_tree_iterator iter = new inorder_tree_iterator(root);
      String result = "";
      while (iter.hasNext()) {
        result += iter.getNext().data + ",";
      }
      return result;
    }   
}