class subset_sum{
  
  static int get_bit(int num, int bit) {
	  int temp = (1 << bit);
	  temp = temp & num;
	  if (temp == 0) {
    	  return 0;
  	  }
	  return 1;
  }
  
  static void get_k_sum_subsets_1(List<Integer> v, Integer target_sum, List<HashSet<Integer>> sets) {
    
    int subSetsCount = (int)(Math.pow((double)2, (double)v.size()));
    
    for (int i=0; i<subSetsCount; i++){
      HashSet<Integer> set = new HashSet<>();
      int sum = 0;
      
      for (int j=0; j<v.size(); j++){
        if (get_bit(i, j) == 1){
          sum += v.get(j);
          if (sum > target_sum){
            break;
          }
          set.add(v.get(j));
        }
      }
      
      if (sum == target_sum){
        sets.add(set);
      }
    }
  }
}  