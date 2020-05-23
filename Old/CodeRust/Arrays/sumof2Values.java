// find_sum_of_two function return true if
// there are two values in array who
// sum to value and returns false otherwise
class findSum{
  static boolean find_sum_of_two(int[] A, int val) {
    //TODO: Write - Your - Code
    Set<Integer> mySet = new HashSet<>();
    
    for (int num: A){
      if (mySet.contains(val - num)){
        return true;
      } 
      mySet.add(num);
    }
    
    return false;
  }
}  