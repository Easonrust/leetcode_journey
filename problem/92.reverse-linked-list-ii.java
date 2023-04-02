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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode before = dummy;
        for(int i=0; i<left-1; ++i){
            before = before.next;
        }

        ListNode after = head;
        for(int i=0; i<right; ++i){
            after = after.next;
        }
        ListNode pre = null;
        ListNode cur = before.next;
        ListNode end = cur;
        while(cur!=after){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        before.next = pre;
        end.next = cur;
        return dummy.next;
    }
}