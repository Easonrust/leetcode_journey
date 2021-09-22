/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
 public ListNode rotateRight(ListNode head, int k) {
  if (k == 0 || head == null || head.next == null) {
   return head;
  }
  int n = 0;
  ListNode cur = head;
  while (cur != null) {
   n++;
   cur = cur.next;
  }

  // 注意旋转问题要取余
  k = k % n;

  ListNode fast = head;
  ListNode slow = head;

  while (k > 0) {
   fast = fast.next;
   k--;
  }
  while (fast.next != null) {
   slow = slow.next;
   fast = fast.next;
  }
  fast.next = head;
  ListNode dummy = slow.next;
  slow.next = null;
  return dummy;
 }
}
// @lc code=end
// 将链表右半部分的 k 的节点拼接到 head 即可。
