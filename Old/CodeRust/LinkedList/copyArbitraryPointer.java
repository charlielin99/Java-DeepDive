class arbitraryPointer{
  public static LinkedListNode deep_copy_arbitrary_pointer(
        LinkedListNode head) {
    if (head == null){
      return head;
    }
    
    LinkedListNode current = head;
    LinkedListNode newHead = null;
    LinkedListNode newPrev = null;
    HashMap<LinkedListNode, LinkedListNode> map = new HashMap<>();
    
    while (current != null){
      LinkedListNode myNode = new LinkedListNode(current.data);
      myNode.arbitrary_pointer = current.arbitrary_pointer;
      
      if (newPrev != null){
        newPrev.next = myNode;
      } else {
        newHead = myNode;
      }
      map.put(current,myNode);
      
      newPrev = myNode;
      
      current = current.next;
    }
    
    LinkedListNode newCurrent = newHead;
    
    while (newCurrent != null){
      if (newCurrent.arbitrary_pointer != null){
        LinkedListNode tempArbitrary = map.get(newCurrent.arbitrary_pointer);
        newCurrent.arbitrary_pointer = tempArbitrary;
      }
      newCurrent = newCurrent.next;
    }
    
    return newHead;
      
      
      
  }  
}  