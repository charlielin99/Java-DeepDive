/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
The recursive part is O(n), because T(n)=2T(n/2)+O(1). And in each recursive call, faster pointer traverse full list of logn, which leads to O(nlogn). So the total Time Complexity is O(nlogn)

space: o(n) for recursive calls

*/

class Solution {
public TreeNode sortedListToBST(ListNode head) {
    return sortedListToBST(head, null);
}

private TreeNode sortedListToBST(ListNode start, ListNode end) {

    if (start == null || start == end)
        return null;

    ListNode fast = start;
    ListNode slow = start;

    while (fast.next != end && fast.next.next != end) {
        fast = fast.next.next;
        slow = slow.next;
    }
    
    TreeNode root = new TreeNode(slow.val);
    root.left = sortedListToBST(start, slow);
    root.right = sortedListToBST(slow.next, end);

    return root;
}
}