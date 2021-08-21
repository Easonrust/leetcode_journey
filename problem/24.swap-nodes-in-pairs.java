/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (54.71%)
 * Likes:    4326
 * Dislikes: 228
 * Total Accepted:    665.2K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head. You
 * must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [1]
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 * 
 * 
 */

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
