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
        ListNode fast = head.next;
        Deque<Integer> dq = new LinkedList<>();
        dq.addLast(slow.val);
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            dq.addLast(slow.val);
            fast = fast.next.next;
        }
        int res = Integer.MIN_VALUE;
        fast = slow.next;
        while(fast!=null){
            res = Math.max(res, dq.removeLast()+fast.val);
            fast = fast.next;
        }
        return res;
    }
}