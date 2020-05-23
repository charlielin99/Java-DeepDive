class regxMatch{
  static boolean regx_match(String text, String pattern) {
    if (text == null || pattern == null){
      return true;
    }
    
    boolean[][] dp = new boolean[text.length()+1][pattern.length()+1];
    dp[0][0] = true;
    for (int i=0; i<pattern.length(); i++){
      if (pattern.charAt(i) == '*' && dp[0][i-1]){
        dp[0][i+1] = true;
      }
    }
    
    for (int i=0; i<text.length(); i++){
      for (int j=0; j<pattern.length(); j++){
        if (pattern.charAt(j) == '.'){
          dp[i+1][j+1] = dp[i][j];
        } 
        if (pattern.charAt(j) == text.charAt(i)){
          dp[i+1][j+1] = dp[i][j];
        }
        if (pattern.charAt(j) == '*'){
          if (pattern.charAt(j-1) != text.charAt(i) && pattern.charAt(j-1) != '.'){
            dp[i+1][j+1] = dp[i+1][j-1];
          } else {
            dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
          }
        }
      }
    }
    
    return dp[text.length()][pattern.length()];
  }
}