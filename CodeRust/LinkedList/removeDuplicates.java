class removeDuplicate{
  public static LinkedListNode remove_duplicates(LinkedListNode head) 
  {
    Set<Integer> mySet = new HashSet<>();
    mySet.add(head.data);
    LinkedListNode mine = head;
    
    while (mine.next != null){
      if (!mySet.contains(mine.next.data)){
        mySet.add(mine.next.data);
        mine = mine.next;
      } else {
        mine.next = mine.next.next;
      } 
    }
    
    return head;
  }
}  