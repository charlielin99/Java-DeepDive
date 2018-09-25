class coinChanging{
  static int solve_coin_change_dp(
      int[] denominations,
      int amount) {
    
    int[] numOfWays = new int[amount + 1];
    numOfWays[0] = 1; //1 way to change amount 0
    
    for (Integer den: denominations){
      for (int i = den; i <= amount; i++){
        numOfWays[i] += numOfWays[i - den];
      }
    }
    
    return numOfWays[amount];
  }
}  