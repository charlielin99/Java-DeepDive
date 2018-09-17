class palindromeSubStrings{
  public static int palindromeHelper(String input, int j, int k){
    int count = 0;
    for (; j>=0 && k<input.length(); j--, k++){
      if (input.charAt(j) != input.charAt(k)){
        break;
      }
      count++;
    }
    return count;
  }
  public static int find_all_palindrome_substrings(String input) {
    int count = 0;
    for (int i=0; i<input.length(); i++){
      count += palindromeHelper(input, i-1, i+1);
      count += palindromeHelper(input, i, i+1);
    }
    return count;
  }
}