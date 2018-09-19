class squareRoot{
  private static final double EPSILON = 0.00001;

  public static double square_root_iterative(double num) {
    double floor = 0;
    double ceil = 1 + num/2;
    
    while (floor < ceil){
      double mid = (ceil + floor) / 2;
      double sqr = mid * mid;
      
      double diff = Math.abs(sqr - num);
      
      if (diff <= EPSILON){
        return mid;
      } else if (sqr < num){
        floor = mid;
      } else {
        ceil = mid;
      }
    }
    
    return -1;
  }

}