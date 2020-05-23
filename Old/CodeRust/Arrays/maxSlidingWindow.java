class maxSlidingWindow{
  public static ArrayDeque<Integer> find_max_sliding_window(
    int[] array, 
    int window_size) {
    
    //int[] result = new int[array.length - window_size - 1];
    //int resultCounter = 0;
    ArrayDeque<Integer> storage = new ArrayDeque<Integer>();
    ArrayDeque<Integer> result = new ArrayDeque<Integer>();
    
    
    for (int i=0 ;i<window_size; i++){
       while (!storage.isEmpty() && array[i] >= array[storage.peekLast()]){
          storage.removeLast(); 
       }
       storage.addLast(i);
    }
    
    result.addLast(array[storage.peekFirst()]);
    //result[resultCounter] = array[storage.peekFirst()];
    //resultCounter++;
    
    for (int i=window_size; i<array.length; i++){
       while (!storage.isEmpty() && array[i] >= array[storage.peekLast()]){
          storage.removeLast(); 
       } 
      
       if (!storage.isEmpty() && storage.peekFirst() <= i - window_size){
          storage.removeFirst(); 
       }
      
       storage.addLast(i);
      
       result.addLast(array[storage.peekFirst()]);
       //result[resultCounter] = array[storage.peekFirst()];
       //resultCounter++;
    }
    
    return result;
    
  }
}  