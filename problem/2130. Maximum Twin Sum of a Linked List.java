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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode right = reverseList(slow.next);
        int res = Integer.MIN_VALUE;
        while(right!=null){
            res = Math.max(res, head.val+right.val);
            head = head.next;
            right = right.next;
        }
        
        return res;
    }
    
    private ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}