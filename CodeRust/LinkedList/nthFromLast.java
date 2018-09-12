class nthFromLast{
  public static LinkedListNode find_nth_from_last(
      LinkedListNode head,
      int n) {
    if (n <= 0){
      return null;
    }
    
    LinkedListNode counter = head;
    int length = 1;
    
    while (counter.next != null){
      length++;
      counter = counter.next;
    }
    
    if (n > length){
      return null;
    }
    
    int diff = length - n;
    
    for (int i=0; i<diff; i++){
      head = head.next;
    }
    
    return head;
  }
}  