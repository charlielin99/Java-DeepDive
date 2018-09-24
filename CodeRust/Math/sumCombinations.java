class sumCombinations{
  static void print_all_sum_rec(
      int target,
      int current_sum,
      int start,
      List<Integer> output,
      List<Integer> result) {
    
    if (target == current_sum){
      for (Integer i: output){
        result.add(i);
      }
      output = new ArrayList<>();
    }
    
    for (int i=start; i < target; i++){
      int tempSum = current_sum + i;
      if (tempSum <= target){
        output.add(i);
        print_all_sum_rec(target, tempSum, i, output, result);
        output.remove(output.size() - 1);
      } else {
        return;
      }
    }

  }
}