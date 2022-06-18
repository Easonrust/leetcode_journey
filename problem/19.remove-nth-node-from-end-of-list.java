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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = findNthFromEnd(dummy,n+1);
        node.next = node.next.next;
        return dummy.next;
    }
    
    private ListNode findNthFromEnd(ListNode node, int n){
        ListNode fast = node;
        for(int i=0;i<n;++i){
            fast = fast.next;
        }
        
        ListNode slow = node;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
// @lc code=end
// 相当于两个速度相同的人赛跑，第一个人提前n距离跑，那么第一个人到达终点时，第二个处于倒数n距离的位置
