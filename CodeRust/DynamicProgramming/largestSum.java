class largestSum{
  static int find_max_sum_sub_array(int[] A) {
    int currentMax = A[0];
    int globalMax = A[0];
    
    for (int i=1; i< A.length; i++){
      if (currentMax < 0){
        currentMax = A[i];
      } else {
        currentMax += A[i];
      }
      
      if (currentMax > globalMax){
        globalMax = currentMax;
      }
    }
    
    return globalMax;
  }
}  