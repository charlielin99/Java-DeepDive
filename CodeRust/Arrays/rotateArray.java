class rotateArray{
  
  static void rotate(List<Integer> arr, int start, int end){
    while (start < end){
      int temp = arr.get(start);
      arr.set(start, arr.get(end));
      arr.set(end, temp);
      start++;
      end--;
    }
  }
  
  static void rotate_array(List<Integer> arr, int n) {
    rotate(arr, 0, arr.size() -1);
    
    n = n % arr.size();
    
    if (n < 0){
      n = n + arr.size();
    }
    
    rotate(arr, 0, n-1);
    rotate(arr, n, arr.size()-1);
    
  }
}  