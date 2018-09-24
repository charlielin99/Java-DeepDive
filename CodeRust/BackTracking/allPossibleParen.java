class all_parentheses{
  
  static List<String> output = new ArrayList<>();
  
  static List<String> print_all_parentheses(int n) {
    StringBuilder temp = new StringBuilder();
    parenRecursive(n, 0, 0, temp);
    return output;
  }
  
  static void parenRecursive(int n, int leftCount, int rightCount, StringBuilder temp){
    if (leftCount >= n && rightCount >= n){
      output.add(temp.toString());
      temp = new StringBuilder();
    }
    
    if (leftCount < n){
      temp.append('{');
      parenRecursive(n, leftCount++, rightCount, temp);
      temp.setLength(temp.length() - 1);
    }
    
    if (rightCount < leftCount){
      temp.append('}');
      parenRecursive(n, leftCount, rightCount++, temp);
      temp.setLength(temp.length() - 1);
    }
  }
         
}  