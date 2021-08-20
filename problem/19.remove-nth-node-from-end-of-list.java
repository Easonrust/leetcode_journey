/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (36.54%)
 * Likes:    6429
 * Dislikes: 347
 * Total Accepted:    975.5K
 * Total Submissions: 2.7M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given the head of a linked list, remove the n^th node from the end of the
 * list and return its head.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1], n = 1
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [1,2], n = 1
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 
 * 
 * 
 * Follow up: Could you do this in one pass?
 * 
 */

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
