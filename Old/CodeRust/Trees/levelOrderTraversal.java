class levelOrderTraversal{
    
  public static String level_order_traversal(
      BinaryTreeNode root) {
    
    if (root == null){
      return null;
    }
    
    List<Queue<BinaryTreeNode>> myList = new ArrayList<>(2);
    myList.add(new ArrayDeque<>());
    myList.add(new ArrayDeque<>());
    
    Queue<BinaryTreeNode> current = myList.get(0);
    Queue<BinaryTreeNode> storage = myList.get(1);
    
    int level = 0;
    String result = "";
    
    current.add(root);
    
    while (!current.isEmpty()){
      BinaryTreeNode temp = current.remove();
      result += temp.data + " ";
      
      if (temp.left != null){
        storage.add(temp.left);
      } 
      if (temp.right != null){
        storage.add(temp.right);
      }
      
      if (current.isEmpty()){
        result += "\n";
        level++;
        current = myList.get(level % 2);
        storage = myList.get((level + 1) % 2);
      }
    }
    
    return result;
  }
}  