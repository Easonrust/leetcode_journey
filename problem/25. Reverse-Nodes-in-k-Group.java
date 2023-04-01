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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head;
        ListNode b = head;
        for(int i=0;i<k;++i){
            if(b==null){
                return head;
            }
            b = b.next;
        }
        
        ListNode newHead = reverse(a,b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }
    
    // private ListNode reverse(ListNode a, ListNode b){
    //     if(a.next==b){
    //         return a;
    //     }
        
    //     ListNode newHead = reverse(a.next, b);
    //     a.next.next = a;
    //     a.next = null;
    //     return newHead;
    // }

    private ListNode reverse(ListNode a, ListNode b){
        ListNode pre = null;
        ListNode cur = a;
        while(cur!=b){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}