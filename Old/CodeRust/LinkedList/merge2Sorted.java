class mergeSortList{
  public static LinkedListNode merge_sorted(
      LinkedListNode head1,
      LinkedListNode head2) {    
    
    if (head1 == null){
      return head2;
    } else if (head2 == null){
      return head1;
    }
    
    LinkedListNode mergedHead = null;
    
    if (head1.data <= head2.data){
      mergedHead = head1;
      head1 = head1.next;
    } else {
      mergedHead = head2;
      head2 = head2.next;
    }
    
    LinkedListNode mergedTail = mergedHead;
    
    while (head1 != null && head2 != null){
      if (head1.data <= head2.data){
        mergedTail.next = head1;
        head1 = head1.next;
      } else {
        mergedTail.next = head2;
        head2 = head2.next;
      }
      
      mergedTail = mergedTail.next;
    }
    
    if (head1 != null){
      mergedTail.next = head1;
    } else if (head2 != null){
      mergedTail.next = head2;
    }
    
    return mergedHead;
      
  }
}