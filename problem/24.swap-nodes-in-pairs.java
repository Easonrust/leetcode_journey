// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
 public ListNode swapPairs(ListNode head) {
  ListNode node = new ListNode(-1);
  ListNode pre = node; // 这一步将循环的递进条件和表头的位置分开
  pre.next = head;
  while (pre.next != null && pre.next.next != null) {
   ListNode l1 = pre.next;
   ListNode l2 = pre.next.next;
   ListNode next = l2.next;
   l1.next = next;
   l2.next = l1;

   pre.next = l2;// 只在第一层循环时有用，让node指向表头
   pre = l1;// 递进到下一组
  }
  return node.next;
 }
}
// @lc code=end
