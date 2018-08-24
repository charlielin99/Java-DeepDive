class searchRotated{
  static int binary_search_rotated(int[] arr,int key) {
    int floor = 0;
    int ceil = arr.length - 1;
    
    while (floor+1 != ceil){
      int mid = floor + (ceil - floor)/2;
      if (arr[mid] == key){
        return mid;
      }
      if (arr[floor] < arr[mid] && key >= arr[floor] && key < arr[mid]){
        ceil = mid - 1;
      } else if (arr[mid] < arr[ceil] && key > arr[mid] && key <= arr[ceil]){
        floor = mid + 1;
      } else if (arr[floor] > arr[mid]){
        ceil = mid -1;
      } else if (arr[mid] > arr[ceil]){
        floor = mid + 1;
      }
    }
    
    return -1;
  }
}