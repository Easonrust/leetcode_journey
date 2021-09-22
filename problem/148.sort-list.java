/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
 public ListNode sortList(ListNode head) {
  if (head == null || head.next == null) {
   return head;
  }
  ListNode slow = head, fast = head.next;
  while (fast != null && fast.next != null) {
   slow = slow.next;
   fast = fast.next.next;
  }
  ListNode t = slow.next;

  // 这里记得要把两个链表断开
  slow.next = null;
  ListNode l1 = sortList(head);
  ListNode l2 = sortList(t);

  // 这里是基本的合并两链表问题
  ListNode dummy = new ListNode();
  ListNode cur = dummy;
  while (l1 != null && l2 != null) {
   if (l1.val <= l2.val) {
    cur.next = l1;
    l1 = l1.next;
   } else {
    cur.next = l2;
    l2 = l2.next;
   }
   cur = cur.next;
  }
  cur.next = l1 == null ? l2 : l1;
  return dummy.next;
 }
}
// @lc code=end
// 先用快慢指针找到链表中点，然后分成左右两个链表，递归排序左右链表。最后合并两个排序的链表即可。
