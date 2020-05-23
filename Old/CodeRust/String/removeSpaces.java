class removeSpaces{
  static boolean isWhiteSpace(char c){
    if (c == '\t' || c == ' '){
      return true;
    }
    return false;
  }
    
  static void remove_white_spaces (char[] s) {
    int read = 0;
    int write = 0;
    
    while (read < s.length){
      if (!isWhiteSpace(s[read])){
        s[write] = s[read];
        write++;
      }
      read++;
    }
    
    s[write] = '\0';
  }
}  