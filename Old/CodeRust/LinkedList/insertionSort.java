class InsertionSort{
   public static LinkedListNode sortedInsert(LinkedListNode head, LinkedListNode node){
     if (node == null){
       return head;
     }
     
     if (head == null || head.data >= node.data){
       node.next = head;
       return node;
     }
     
     LinkedListNode curr = head;
     
     while (curr.next != null && curr.next.data < node.data){
       curr = curr.next;
     }
     node.next = curr.next;
     curr.next = node;
     
     return head;
   }
       
     
       
   public static LinkedListNode insertion_sort(
        LinkedListNode head) {
     
     LinkedListNode curr = head;
     LinkedListNode sorted = null;
     
     while (curr != null){
       LinkedListNode temp = curr.next;
       sorted = sortedInsert(sorted, curr);
       curr = temp;
     }
     
     return sorted;
    }
}  