class stack_using_queue{
   
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();
    void push(int data) {
      if (queue1.isEmpty()){
        queue1.add(data);
      } else {
        queue2.add(data);
        while (!queue1.isEmpty()){
          queue2.add(queue1.remove());
        }
        swap();
      }
    }
  
    boolean isEmpty() {
      return queue1.size() + queue2.size() == 0;
    }

    int pop() throws Exception {
      if (isEmpty()){
        throw new Exception("Cannot pop empty");
      }
      return queue1.remove();
    }
  
    void swap(){
      Queue<Integer> temp = queue1;
      queue1 = queue2;
      queue2 = temp;
    }
}