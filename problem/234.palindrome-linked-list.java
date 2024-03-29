/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode right = reverse(slow.next);
        while(right!=null){
            if(head.val!=right.val){
                return false;
            }
            head = head.next;
            right = right.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode node) {
        if(node==null||node.next==null){
            return node;
        }
        ListNode newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }
}