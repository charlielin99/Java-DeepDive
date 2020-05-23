class permuteString{
  static List<String> permute_string(String input) {
    List<String> result = new ArrayList<String>();
    permute_string(input.toCharArray(), 0, input.length()-1, result);
    return result;
  }
  
  static void permute_string(char[] arr, int start, int end, List<String> result){
    if (start == end){
      String temp = new String(arr);
      result.add(temp);
      return;
    }
    
    for (int i=start; i<=end; i++){
      swap(arr, start, i);
      permute_string(arr, start+1, end, result);
      swap(arr, start, i);
    }
  }
  
  static void swap(char[] arr, int start, int end){
    char temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
  }
}  