class removeDuplicates{
  static void remove_duplicates(char[] str){
    Set<Character> mySet = new HashSet<>();
    int read = 0;
    int write = 0;
    
    while (read < str.length){
      if (!mySet.contains(str[read])){
        mySet.add(str[read]);
        str[write] = str[read];
        write++;
      }
      read++;
    }
    
    str[write] = '\0';
  }
}  