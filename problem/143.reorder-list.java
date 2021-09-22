/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
 public void reorderList(ListNode head) {
  if (head == null || head.next == null) {
   return;
  }
  ListNode slow = head;
  ListNode fast = head.next;
  while (fast != null && fast.next != null) {
   slow = slow.next;
   fast = fast.next.next;
  }
  ListNode rightHead = slow.next;
  slow.next = null;
  ListNode pre = rightHead;
  ListNode cur = pre.next;
  pre.next = null;
  while (cur != null) {
   ListNode p = cur.next;
   cur.next = pre;
   pre = cur;
   cur = p;
  }

  ListNode n1 = head;
  ListNode n2 = pre;
  ListNode q1 = new ListNode();
  ListNode q2 = new ListNode();
  while (q2 != null) {
   q1 = n1.next;
   q2 = n2.next;
   n1.next = n2;
   n2.next = q1;
   n1 = q1;
   n2 = q2;

  }
 }
}
// @lc code=end
// 先通过快慢指针找到链表中点，将链表划分为左右两部分。之后反转右半部分的链表，然后将左右两个链接依次连接即可。
