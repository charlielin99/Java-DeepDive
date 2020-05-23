class binary_search{
  //a is sorted array
  static int bin_search(int[] a, int key) {
    int floorIndex = 0;
    int ceilIndex = a.length - 1;
    
    while (floorIndex+1 != ceilIndex){
      int midIndex = floorIndex + ((ceilIndex - floorIndex) / 2);
      
      if (a[midIndex] == key){
        return midIndex;
      } else if (a[midIndex] < key) {
        floorIndex = midIndex;
      } else {
        ceilIndex = midIndex;
      }
    }
    
    return -1;
  }
}  