class makeZeroes{
  static int[][] make_zeroes(int[][] matrix) {
    
    if (matrix.length == 0){
      return matrix;
    }
    
    Set<Integer> zeroRows = new HashSet<>();
    Set<Integer> zeroColumns = new HashSet<>();
    
    for (int i=0; i<matrix.length; i++){
      for (int j=0; j<matrix[i].length; j++){
        if (matrix[i][j] == 0){
          if (!zeroRows.contains(i)){
            zeroRows.add(i);
          }
          if (!zeroColumns.contains(j)){
            zeroColumns.add(j);
          }
        }
      }
    }
    
    for (int r: zeroRows){
      for (int j=0; j<matrix[r].length; j++){
        matrix[r][j] = 0;
      }
    }
    
    for (int c: zeroColumns){
      for (int j=0; j<matrix.length; j++){
        matrix[j][c] = 0;
      }
    }
    
    return matrix;
  }
}  