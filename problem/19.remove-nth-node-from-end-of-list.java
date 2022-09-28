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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode x = findNthFromEnd(dummy, n+1);
        x.next = x.next.next;
        return dummy.next;
    }
    
    private ListNode findNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        for(int i=0; i<n; ++i){
            first = first.next;
        }
        ListNode second = head;
        while(first!=null){
            first = first.next;
            second = second.next;
        }
        return second;
    }
}