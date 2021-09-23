/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
  ListNode dummy = new ListNode();
  int carry = 0;
  ListNode cur = dummy;

  // 注意这里有一个carry!=0的判断
  while (l1 != null || l2 != null || carry != 0) {
   int s = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
   carry = s / 10;
   cur.next = new ListNode(s % 10);
   cur = cur.next;
   l1 = l1 == null ? null : l1.next;
   l2 = l2 == null ? null : l2.next;
  }
  return dummy.next;
 }
}
// @lc code=end