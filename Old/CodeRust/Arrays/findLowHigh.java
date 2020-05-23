class findLowHigh{
  static int find_low_index(
      List<Integer> arr,
      int key) {
    //TODO: Write - Your - Code
    int low = 0;
    int high = arr.size() - 1;
    
    while (low <= high){
      int mid = low + (high - low)/2;
      
      if (arr.get(mid) < key){
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    if (arr.get(low) == key){
      return low;
    } 
    return -1;
        
  }

  static int find_high_index(
      List<Integer> arr,
      int key) {
   //TODO: Write - Your - Code
    int low = 0;
    int high = arr.size() - 1;
    
    while (low <= high){
      int mid = low + (high - low)/2;
      
      if (arr.get(mid) <= key){
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    
    if (arr.get(high) == key){
      return high;
    } 
    
    return -1;
        
  }
}  