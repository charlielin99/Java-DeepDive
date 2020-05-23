class all_parentheses{
  static List<Character> print_all_parentheses(int n) {
    List<Character> output = new ArrayList<Character>();
    List<Character> storage = new ArrayList<Character>();
    parenthesesRec(n, 0, 0, storage, output);
    return output;
  }
  
  static void parenthesesRec(int n, int leftCount, int rightCount, 
                             List<Character> storage, List<Character> output){
    
    if (leftCount >= n && rightCount >=n) {
      for (char c: storage){
        output.add(c);
      }
      output.add(',');
    }
    
    if (leftCount < n) {
      storage.add('{');
      parenthesesRec(n, leftCount + 1, rightCount, storage, output);
      storage.remove(storage.size() - 1);
    }

    if (rightCount < leftCount) {
      storage.add('}');
      parenthesesRec(n, leftCount, rightCount + 1, storage, output);
      storage.remove(storage.size() - 1);
    }
  }
}  