class sumOfThree{
  public static Boolean
  find_sum_of_three(int arr[], int required_sum) {
    Arrays.sort(arr);
    for (int i=0; i<arr.length -2; i++){
      int remainingSum = required_sum - arr[i];
      if (findPair(arr, remainingSum, i+1)){
        return true;
      }
    }
    return false;
  }
  
  public static Boolean findPair(int[] arr, int remainingSum, int startIndex){
    for (int i= startIndex, j = arr.length - 1; i<j;){
      int sum = arr[i] + arr[j];
      if (sum == remainingSum){
        return true;
      }
      
      if (sum < remainingSum){
        i++;
      } else {
        j--;
      }
    }
    
    return false;
  }
}  