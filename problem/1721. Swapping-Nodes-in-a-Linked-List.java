/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int l = 0;
        ListNode frontNode = new ListNode();
        ListNode endNode = new ListNode();
        ListNode curNode = head;
        while (curNode != null) {
            l++;
            if (endNode != null) {
                endNode = endNode.next;
            }
            if (l == k) {
                frontNode = curNode;
                endNode = head;
                // 此时endNode和curNode之间有k步
            }
            curNode = curNode.next;
        }
        int temp = frontNode.val;
        frontNode.val = endNode.val;
        endNode.val = temp;
        return head;

    }
}
