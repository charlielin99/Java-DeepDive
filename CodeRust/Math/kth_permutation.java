class kth_permutation{
  static int factorial(int n){
    if (n==0 || n==1){
      return 1;
    }
    return n * factorial(n-1);
  }
  
  static void find_kth_permutation(
      List<Character> v, 
      int k,
      StringBuilder result) {
    
    if (v.isEmpty()){
      return;
    }
    
    int n = v.size();
    int blockSize = factorial(n - 1);
    int index = (k - 1) / blockSize;
    
    result.append(v.get(index));
    v.remove(index);
    
    k = k - (blockSize * index);
    
    find_kth_permutation(v, k, result);
  } 
}  