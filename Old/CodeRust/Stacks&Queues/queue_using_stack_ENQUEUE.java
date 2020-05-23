class queue_using_stack{
  
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();
  
    void enqueue(int data) {
      stack1.push(data);
    }

    boolean isEmpty() {
      return stack1.size() + stack2.size() == 0;
    }

    int dequeue() throws Exception {
       if (isEmpty()){
         throw new Exception("empty");
       }
      
      if (stack2.size() == 0){
        while (stack1.size() > 0){
          stack2.push(stack1.pop());
        }
      }
        return stack2.pop();
    }
}  