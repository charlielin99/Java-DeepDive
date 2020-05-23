class stock_prices{
  public static Tuple find_buy_sell_stock_prices(
    int[] array) {
    //TODO: Write - Your - Code
    /*
     class Tuple<X, Y> { 
      public X x; 
      public Y y; 

      public Tuple(X x, Y y) { 
        this.x = x; 
        this.y = y; 
      } 
    }
    */
    
    int minPrice = array[0];
    int maxProfit = array[1] - array[0];
    
     for (int i = 1; i < array.length; i++) {
        int currentPrice = array[i];
        int potentialProfit = currentPrice - minPrice;

        maxProfit = Math.max(maxProfit, potentialProfit);
        minPrice = Math.min(minPrice, currentPrice);
    }
    
    return new Tuple<Integer, Integer>(minPrice, maxProfit + minPrice);

  }
}  