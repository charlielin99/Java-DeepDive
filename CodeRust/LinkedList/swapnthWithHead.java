class swapNth{
  // Node indices starts from 1.
  static LinkedListNode
  swap_nth_node(LinkedListNode head, int n) {
    
    if (head == null || n == 1){
      return head;
    }
    
    LinkedListNode previous = null;
    LinkedListNode current = head;
    
    for (int i=1; current != null && i<n; i++){
      previous = current;
      current = current.next;
    }
    
    if (current == null){
      return head;
    }
    
    previous.next = head;
    LinkedListNode temp = head.next;
    head.next = current.next; 
    current.next = temp;
    
    return current;
  }
}  