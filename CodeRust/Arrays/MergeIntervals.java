class MergeIntervals{
  static ArrayList<Tuple<Integer,Integer>> merge_intervals(
      ArrayList<Tuple<Integer,Integer>> v1) {  
    //TODO: Write - Your - Code
    ArrayList<Tuple<Integer, Integer>> v2 = new ArrayList<>();
    v2.add(v1.get(0));
    
    for (int i=1; i<v1.size(); i++){
      if (v1.get(i).x <= v2.get(v2.size()-1).y){
        v2.get(v2.size()-1).y = Math.max(v2.get(v2.size()-1).y, v1.get(i).y);
      } else {
        v2.add(v1.get(i));
      }
    }
    
    return v2;
  }
}  