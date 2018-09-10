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
    int minPrice = Math.min(array[0], array[1]);
    int maxPrice = Math.max(array[0], array[1]);
    int maxProfit = maxPrice - minPrice;
    
    
    for (int i=1; i<array.length; i++){
      int currentPrice = array[i];
      int potentialProfit = currentPrice - minPrice;
      
      minPrice = Math.min(minPrice, currentPrice);
      
      if (potentialProfit > maxProfit){
        maxProfit = potentialProfit;
        maxPrice = currentPrice;
      }
    }
    
    return new Tuple<Integer, Integer>(minPrice, maxPrice);
    
    
  }
}  