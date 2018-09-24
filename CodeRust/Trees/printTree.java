class printTree{
  public static String display_tree_perimeter(BinaryTreeNode root) {
    String result = "";
    
    if (root != null) {
      result += root.data + " ";
    }
    
    result += left_perimeter(root.left);
    
    if (root.left != null && root.right != null){
      result += leaf_perimeter(root);
    } 
    
    result += right_perimeter(root.right);
    
    return result; 
  }
  
  public static String left_perimeter (BinaryTreeNode root){
    
    String temp = "";
   
    while (root != null){
      int currentValue = root.data;
      
      if (root.left != null){
        root = root.left;
      } else if (root.right != null){
        root = root.right;
      } else {
        break;
      }
      
      temp += currentValue + " ";
    }
    
    return temp;
  }
  
  public static String leaf_perimeter(BinaryTreeNode root){
    String temp = "";
    leaf_perimeter(root, temp);
    return " " +temp+" " ;
  }
  
  public static void leaf_perimeter(BinaryTreeNode root, String temp){
    
    if (root != null){
      leaf_perimeter(root.left, temp);
      leaf_perimeter(root.right, temp);
    }
    
    if (root.left == null && root.right == null){
      temp += root.data + " ";
    }
    
  }
  
  public static String right_perimeter(BinaryTreeNode root){
    
    Deque<Integer> stack = new ArrayDeque<>();
    String temp = "";
    
    while (root != null){
      
      int current = root.data;
      
      if (root.right != null){
        root = root.right;
      } else if (root.left != null){
        root = root.left;
      } else {
        break;
      }
      
      stack.push(current);
      temp += stack.pop() + " ";
    }
    
    return temp;
  }

}  