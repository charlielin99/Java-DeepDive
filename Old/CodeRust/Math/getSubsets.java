class getSubsets{
  static void get_all_subsets(List<Integer> v, List<HashSet<Integer>> sets) {
	   
    int complexity = (int) Math.pow((double)2, (double)v.size());
     
     for (int i=0; i<complexity; i++){
       HashSet<Integer> set = new HashSet<>();
       for (int j=0; j<v.size(); j++){
         if (getBit(i, j) == 1){
           int x = v.get(j);
           set.add(x);
         }
       }
       sets.add(set);
     }
  }
  
  static int getBit(int num, int bit){
    int temp = 1 << bit;
    temp = temp & num;
    if (temp == 0){
      return 0;
    }
    return 1;
  }
}  