// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
 public ListNode removeNthFromEnd(ListNode head, int n) {
  ListNode firstRun = head;
  ListNode secondRun = head;
  while (n != 0) {
   n--;
   firstRun = firstRun.next;
  }
  if (firstRun == null) {
   return head.next;
  }
  while (firstRun.next != null) {
   firstRun = firstRun.next;
   secondRun = secondRun.next;
  }
  secondRun.next = secondRun.next.next;
  return head;
 }
}
// @lc code=end
// 相当于两个速度相同的人赛跑，第一个人提前n距离跑，那么第一个人到达终点时，第二个处于倒数n距离的位置
