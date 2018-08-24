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
    Tuple<Integer, Integer> myTuple = new Tuple<Integer, Integer>(array[0], array[1]);
    
    for (int i=1; i<array.length; i++){
      int currentPrice = array[i];
      int potentialProfit = currentPrice - minPrice;
      
      minPrice = Math.min(minPrice, currentPrice);
      if (potentialProfit > maxProfit){
        maxProfit = potentialProfit;
        myTuple.x = minPrice;
        myTuple.y = currentPrice;
      }
    }
    
    return myTuple;
  }
}  