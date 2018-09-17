class queue_using_stack{
    
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();
  
    void enqueue(int data) {
      while (!stack1.isEmpty()){
        stack2.push(stack1.pop());
      }
      
      stack1.push(data);
      
      while (!stack2.isEmpty()){
        stack1.push(stack2.pop());
      }
    }

    boolean isEmpty() {
      return stack1.size() + stack2.size() == 0;
    }

    int dequeue() throws Exception {
       if (isEmpty()){
         throw new Exception("No");
       }
      return stack1.pop();
    }
}  