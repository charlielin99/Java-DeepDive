class pythagoreanTriplet{
  static List<int[]> find_pythagorean_triplets(int[] arr) {

    List<int[]> triplets = new ArrayList<int[]>();
    Arrays.sort(arr);
    for (int i=0; i<arr.length; i++){
      if (arr[i] == 0){
        continue;
      }
      int c2 = arr[i] * arr[i];
      int j = 0;
      int k = arr.length - 1;
      
      while (j < k){
        if (j == i || arr[j] == 0){
          j++;
          continue;
        }
        if (k == i || arr[k] == 0){
          k--;
          continue;
        }
        
        int a2 = arr[j] * arr[j];
        int b2 = arr[k] * arr[k];
        
        if ((a2 + b2) == c2){
          triplets.add(new int[] {arr[j], arr[k], arr[i]});
          break;
        } else if ((a2 + b2) < c2){
          j++;
        } else {
          k--;
        }
      }
    }
    
    return triplets;
  }
}  