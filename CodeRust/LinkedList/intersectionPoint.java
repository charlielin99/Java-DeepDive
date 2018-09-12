class Intersect{
  public static int getLength(LinkedListNode head){
    int length = 0;
    while (head != null){
      head = head.next;
      length++;
    }
    return length;
  }
  
  public static LinkedListNode intersect(
    LinkedListNode head1,
    LinkedListNode head2) {
    
    LinkedListNode list1;
    LinkedListNode list2;
    int head1Length = getLength(head1);
    int head2Length = getLength(head2);
    int lengthDiff = 0;
    
    if (head1Length >= head2Length){
      lengthDiff = head1Length - head2Length;
      list1 = head1;
      list2 = head2;
    } else {
      lengthDiff = head2Length - head1Length;
      list1 = head2;
      list2 = head1;
    }
    
    while (lengthDiff > 0){
      list1 = list1.next;
      lengthDiff--;
    }
    
    while (list1 != null){
      if (list1 == list2){
        return list1;
      }
      list1 = list1.next;
      list2 = list2.next;
    }
    
    return null;
  } 
}  