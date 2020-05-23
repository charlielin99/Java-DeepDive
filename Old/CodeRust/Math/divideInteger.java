class divideInteger{
  public static int integer_divide(int x, int y) {
    
    if (y == 0){
      return -1;
    }
    if (x == y){
      return 1;
    }
    if (x < y){
      return 0;
    }
    if (y == 1){
      return x;
    }
    
    int quotient = 1;
    int temp = y;
    
    while (temp < x){
      temp <<= 1;
      quotient <<=1;
    }
    
    if (temp == x) {
      return quotient;
    } else {
      temp >>= 1;
      quotient >>= 1;
      return quotient + integer_divide(x - temp, y);
    }
    
  }
}  