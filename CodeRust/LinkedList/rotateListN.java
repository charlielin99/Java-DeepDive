class rotateList{
   public static LinkedListNode rotate_list(LinkedListNode head, int n) {
     if (head == null || n == 0){
       return head;
     }
     
     int length = 0;
     LinkedListNode count = head;
     while (count != null){
       count = count.next;
       length++;
     }
     
     n = n % length;
     if (n == 0){
       return head;
     }
     if (n < 0){
       n = n + length;
     }
     
     int rotationsCount = length - n -1;
     LinkedListNode temp = head;
     
     while (rotationsCount > 0){
       temp = temp.next;
       rotationsCount --;
     }
     
     LinkedListNode newHead = temp.next;
     temp.next = null;
     temp = newHead;
     
     while (temp.next != null){
       temp = temp.next;
     }
     temp.next = head;
     
     return newHead;
     
  }
}  