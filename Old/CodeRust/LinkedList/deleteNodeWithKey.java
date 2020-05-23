class deleteNode{
  public static LinkedListNode delete_node(LinkedListNode head, int key) 
  {
    LinkedListNode current = head;
    LinkedListNode previous = null;
    
    while (current != null){
      if (current.data == key){
        if (current == head){
          head = head.next;
          current = head;
        } else {
          current = current.next;
          previous.next = current;
        }
      } else {
        previous = current;
        current = current.next;
      }
    }
    
    return head;
  }
}  