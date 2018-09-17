class quickSort{
  static void quick_sort(int[] arr) {
    quick_sort(arr, 0, arr.length - 1);
  }
  
  static void quick_sort(int[] arr, int left, int right){
    if (left >= right){
      return;
    }
    
    int pivot = arr[(left+right)/2];
    int index = partition(arr, left, right, pivot);
    quick_sort(arr, left, index -1);
    quick_sort(arr, index, right);
  }
  
  static int partition(int[] arr, int left, int right, int pivot){
    while (left <= right){
      while (arr[left] < pivot){
        left++;
      }
      while (arr[right] > pivot){
        right--;
      }
      
      if (left <= right){
        swap(arr, left, right);
        left++;
        right--;
      }
    }
    return left;
  }
  
  static void swap(int[] arr, int left, int right){
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
           
}  