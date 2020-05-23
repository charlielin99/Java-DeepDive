class addIntegers{
  static LinkedListNode add_integers(
      LinkedListNode integer1, 
      LinkedListNode integer2) {
    
    LinkedListNode result = null;
    LinkedListNode lastPtr = null;
    int carry = 0;
    
    while (integer1 != null || integer2 != null || carry != 0){
      int value1 = (integer1 == null ? 0 : integer1.data);
      int value2 = (integer2 == null ? 0 : integer2.data);
      int calcValue = value1 + value2 + carry;
      LinkedListNode myNode = new LinkedListNode(calcValue % 10);
      carry = calcValue / 10;
      if (result == null){
        result = myNode;
      } else {
        lastPtr.next = myNode;
      }
      lastPtr = myNode;
      
      if (integer1 != null){
        integer1 = integer1.next;
      }
      if (integer2 != null){
        integer2 = integer2.next;
      }
    }
    
    return result;
      
  }
}  