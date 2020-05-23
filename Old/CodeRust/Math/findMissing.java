class findMissing{
  static int find_missing(List<Integer> input) {
    //TODO: Write - Your - Code
    int sumOfList = 0;
    for (int i: input){
      sumOfList += i;
    }
    
    int n = input.size() + 1;
    int triangle = (n * (n+1)) / 2;
    
    return triangle - sumOfList;
      
  }
}  