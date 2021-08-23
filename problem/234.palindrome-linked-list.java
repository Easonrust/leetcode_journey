/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (43.47%)
 * Likes:    6200
 * Dislikes: 463
 * Total Accepted:    733.6K
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,2,2,1]'
 *
 * Given the head of a singly linked list, return true if it is a
 * palindrome.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,2,1]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [1, 10^5].
 * 0 <= Node.val <= 9
 * 
 * 
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
 public boolean isPalindrome(ListNode head) {
  if (head.next == null) {
   return true;
  }
  ListNode first = head;
  ListNode second = head;
  while (first != null && first.next != null) {
   first = first.next.next;
   second = second.next;
  }
  cut(head, second);
  ListNode firstList = head;
  ListNode secondList = null;
  if (first == null) {
   secondList = reverse(second);
   // 偶数

  } else if (first.next == null) {
   // 奇数
   secondList = reverse(second.next);
  }
  return isEqual(firstList, secondList);
 }

 private void cut(ListNode head, ListNode second) {
  while (head.next != second) {
   head = head.next;
  }
  head.next = null;
 }

 private ListNode reverse(ListNode head) {
  ListNode newHead = new ListNode(-1);
  while (head != null) {
   ListNode next = head.next;
   head.next = newHead.next;
   newHead.next = head;
   head = next;
  }
  return newHead.next;
 }

 private boolean isEqual(ListNode l1, ListNode l2) {
  while (l1 != null && l2 != null) {
   if (l1.val != l2.val) {
    return false;
   }
   l1 = l1.next;
   l2 = l2.next;
  }
  return true;
 }
}
// @lc code=end
// 注意在反转链表那里不要跟相邻链表交换位置那个搞混了，反转链表是一个元素一个元素的变
