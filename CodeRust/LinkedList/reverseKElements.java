class reverseK{
  static LinkedListNode reverse_k_nodes(
    LinkedListNode head,
    int k) {
    
    if (k <= 1 || head == null){
      return head;
    }
    
    LinkedListNode reversed = null;
    LinkedListNode previousTail = null;
    
    while (head != null && k > 0){
      LinkedListNode currentHead = null;
      LinkedListNode currentTail = head;
      int n = k;
      
      while (head != null && n > 0){
        LinkedListNode temp = head.next;
        head.next = currentHead;
        currentHead = head;
        head = temp;
        n--;
      }
      
      if (reversed == null){
        reversed = currentHead;
      }
      
      if (previousTail != null){
        previousTail.next = currentHead;
      }
      previousTail = currentTail;
    }
    
    return reversed;
    
  }
}  