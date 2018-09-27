class searchMatrix{
  public static IntPair
  search_in_matrix(int matrix[][], int value) {
    int rowValue = 0;
    int columnValue = matrix[0].length - 1;
    
    while (columnValue >= 0 && rowValue < matrix[0].length){
      if (matrix[rowValue][columnValue] == value){
        return new IntPair (rowValue, columnValue);
      }
      
      if (matrix[rowValue][columnValue] < value){
        rowValue++;
      } else {
        columnValue--;
      }
    }
    
    return new IntPair (-1, -1);
  }
}  