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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        while(l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(-1);
        int carry = 0;
        while(!stack1.isEmpty()||!stack2.isEmpty()||carry>0){
            int val = 0;
            if(!stack1.isEmpty()){
                val += stack1.pop();
            }
            if(!stack2.isEmpty()){
                val += stack2.pop();
            }
            val += carry;
            carry = val/10;
            ListNode newNode = new ListNode(val%10);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
        return dummy.next;
    }
}