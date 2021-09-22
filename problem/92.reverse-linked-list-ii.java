/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
 public ListNode reverseBetween(ListNode head, int left, int right) {
  if (head == null || head.next == null || left == right) {
   return head;
  }
  ListNode dummy = new ListNode();
  dummy.next = head;
  ListNode pre = dummy;
  for (int i = 0; i < left - 1; ++i) {
   pre = pre.next;
  }
  ListNode p = pre.next;
  ListNode p2 = p;
  ListNode cur = pre.next.next;
  for (int i = 0; i < right - left; ++i) {
   ListNode q = cur.next;
   cur.next = p;
   p = cur;
   cur = q;
  }
  p2.next = cur;
  pre.next = p;
  return dummy.next;
 }
}
// @lc code=end
// 画图判断即可
