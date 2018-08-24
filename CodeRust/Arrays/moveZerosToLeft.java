class moveZerosToLeft{
  static void move_zeros_to_left_in_array(int[] A) {
    int read = A.length - 1;
    int write = A.length - 1;
    
    while (read >= 0){
      if (A[read] != 0){
        A[write--] = A[read];
      }
     read--;
    }
    
    while (write >= 0){
      A[write--] = 0;
    }
  }
}  