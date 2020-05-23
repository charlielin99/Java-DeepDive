class fib{
  static int get_fibonacci(int n) {
    if (n == 0 || n == 1){
      return n;
    }
    
    int n1 = 0;
    int n2 = 1;
    int result = 0;
    
    for (int i=2; i<=n; i++){
      result = n1 + n2;
      n1 = n2;
      n2 = result;
    }
    
    return result;
  }  
}  