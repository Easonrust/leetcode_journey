/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
 public ListNode deleteDuplicates(ListNode head) {
  ListNode res = new ListNode(0);
  res.next = head;
  ListNode cur = res;
  while (cur.next != null && cur.next.next != null) {
   if (cur.next.val == cur.next.next.val) {
    int val = cur.next.val;
    while (cur.next != null && cur.next.val == val) {
     cur.next = cur.next.next;
    }
   } else {
    cur = cur.next;
   }
  }
  return res.next;
 }
}
// @lc code=end
