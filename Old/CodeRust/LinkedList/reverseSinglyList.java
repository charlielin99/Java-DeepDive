class Reverse{
  public static LinkedListNode reverse_list(
      LinkedListNode head) {
    LinkedListNode current = head;
    LinkedListNode previous = null;
    LinkedListNode nextNode = null;
    
    while (current != null){
      nextNode = current.next;
      current.next = previous;
      
      previous = current;
      current = nextNode;
    }
    //TODO: Write - Your - Code
    return previous;
  }
}  