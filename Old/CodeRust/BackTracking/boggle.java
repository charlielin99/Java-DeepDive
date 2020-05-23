class boggle {
  
    char[][] grid;
    Set<String> dictionary;
    boolean[][] state;

    ArrayList<IntPair> find_all_nbrs(int x, int y) {
      ArrayList<IntPair> nbrs = new ArrayList<IntPair>();

      int start_x = Math.max(0, x - 1);
      int start_y = Math.max(0, y - 1);
      int end_x = Math.min(grid.length - 1, x + 1);
      int end_y = Math.min(grid.length - 1, y + 1);

      for (int i = start_x; i <= end_x; ++i) {
        for (int j = start_y; j <= end_y; ++j) {
          if (state[i][j]) {
            continue;
          }
          nbrs.add(new IntPair(i, j));
        }
      }
      return nbrs;
    }
  
  
  boggle(char[][] g, HashSet<String> d){
    grid = g;
    dictionary = d;
    state = new boolean[g.length][g.length];
    for (int i = 0; i < g.length; ++i) {
      for (int j = 0; j < g.length; ++j) {
        state[i][j] = false;
      }
    }
  }
  
  public HashSet<String> find_all_words(){
    HashSet<String> words = new HashSet<String>();
    StringBuilder current_word = new StringBuilder();
    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid.length; ++j) {
        find_words_rec(i, j, current_word, words);
      }
    }
    
    return words;
  }
  
  
  void find_words_rec(int i, int j, 
        StringBuilder current, 
        HashSet<String> words) {

    if (current.length() > 0 && 
        dictionary.contains(current.toString())) {
      words.add(current.toString());
    }

    // we can really speed up our algorithm if 
    // we have prefix method available
    // for our dictionary by using code like below
    /*
    if (!dictionary.is_prefix(current)) {
      // if current word is not prefix of any word in dictionary
      // we don't need to continue with search
      return;
    }
    */

    ArrayList<IntPair> nbrs = find_all_nbrs(i, j);
    for (IntPair pr : nbrs) {      
      current.append(grid[pr.first][pr.second]);
      state[pr.first][pr.second] = true;
      find_words_rec(pr.first, pr.second, current, words);
      current.setLength(current.length() - 1);
      state[pr.first][pr.second] = false;
    }
  }
  
  
}