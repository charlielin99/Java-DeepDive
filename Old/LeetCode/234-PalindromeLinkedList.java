/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if (fast != null){
            slow = slow.next;
        }
        
        slow = reverseList(slow);
        
        while (slow != null){
            if (slow.val != head.val){
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        
        return true;
        
    }
    
    public ListNode reverseList(ListNode node){
        ListNode current = node;
        ListNode previous = null;
        ListNode nextNode = null;
        
        while (current != null){
            nextNode = current.next;
            current.next = previous;
            
            previous = current;
            current = nextNode;
        }
        
        return previous;
    }
}
