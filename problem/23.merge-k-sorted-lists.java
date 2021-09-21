/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
 public ListNode mergeKLists(ListNode[] lists) {
  int n = lists.length;
  if (lists == null || n == 0) {
   return null;
  }
  for (int i = 1; i < n; ++i) {
   lists[i] = mergeTwoLists(lists[i - 1], lists[i]);
  }
  return lists[n - 1];
 }

 private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
  ListNode dummy = new ListNode();
  ListNode cur = dummy;
  while (l1 != null && l2 != null) {
   if (l1.val < l2.val) {
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
// 合并前后两个链表，结果放在后一个链表位置上，依次循环下去。
