/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
 public ListNode detectCycle(ListNode head) {
  Set<ListNode> set = new HashSet<>();
  ListNode node = head;
  while (node != null) {
   if (set.contains(node)) {
    return node;
   }
   set.add(node);
   node = node.next;
  }
  return null;
 }
}

// 用hashset处理环问题
// @lc code=end
