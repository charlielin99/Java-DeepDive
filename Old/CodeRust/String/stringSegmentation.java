class stringSegmentation{
  public static boolean can_segment_string(String s, Set<String> dict) {
    Set<String> solved = new HashSet<>();
    return can_segment_string(s, dict, solved);
  }
  
  public static boolean can_segment_string(String s, Set<String> dict, Set<String> solved){
    for (int i=1; i<=s.length(); i++){
      String first = s.substring(0, i);
      if (dict.contains(first)){
        String second = s.substring(i);
        
        if (second == null || second.length() == 0 || dict.contains(second)){
          return true;
        }
        
        if (!dict.contains(second)){
          if (can_segment_string(second, dict, solved)){
            return true;
          }
          solved.add(second);
        }
      }
    }
    return false;
  }
}  