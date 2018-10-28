class n_queens{
  public static void solve_n_queens(int n, List<List<Integer>> results) {
    List<Integer> solution = new ArrayList<Integer>(n);
    Stack<Integer> sol_stack = new Stack<Integer>();
  
    for (int i = 0; i < n; ++i) {
      solution.add(-1);
    }

    int row = 0;
    int col = 0;

    while(row < n){
      while(col < n){
        if(is_valid_move(row, col, solution)){ 
          sol_stack.push(col);
          solution.set(row, col);
          row++;
          col = 0;
          break;
        }
        col++;
      }
 
      if(col == n){
        if(!sol_stack.empty()){
          col = sol_stack.peek() + 1;
          sol_stack.pop();
          row--;
        }
        else{
          // no more solutions exist
          break;
        }
      }
 
      if(row == n){  
        // add the solution into results
        results.add(new ArrayList<Integer>(solution));
      
        //backtrack to find the next solution
        row--;
        col = sol_stack.peek() + 1;
        sol_stack.pop();   
      }  
    }
  }
  
  
  static boolean is_valid_move(
      int proposed_row, 
      int proposed_col, 
      List<Integer> solution) {  

    // we need to check with all queens
    // in current solution
    for (int i = 0; i < proposed_row; ++i) {
      int old_row = i;
      int old_col = solution.get(i);

      int diagonal_offset = proposed_row - old_row;
      if (old_col == proposed_col ||
        old_col == proposed_col - diagonal_offset ||
        old_col == proposed_col + diagonal_offset) {
        return false;
    }
  }

  return true;
 } 
}  