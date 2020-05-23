class stack_using_queue{
  
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();
  
    void push(int data) {
      queue1.add(data);
    }
  
    boolean isEmpty() {
      return queue1.size() + queue2.size() == 0;
    }

    int pop() throws Exception {
      
      if (isEmpty()){
        throw new Exception("Cannot pop empty");
      }
      
      while (queue1.size() > 1){
        queue2.add(queue1.remove());
      }
      
      int temp = queue1.remove();
      
      swap();
      
      return temp;
    }
  
    void swap(){
      Queue<Integer> temp = queue1;
      queue1 = queue2;
      queue2 = temp;
    }
}