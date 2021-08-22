import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (57.21%)
 * Likes:    2694
 * Dislikes: 208
 * Total Accepted:    260.7K
 * Total Submissions: 454.5K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: l1 = [7,2,4,3], l2 = [5,6,4]
 * Output: [7,8,0,7]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [8,0,7]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have
 * leading zeros.
 * 
 * 
 * 
 * Follow up: Could you solve it without reversing the input lists?
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
  Stack<Integer> stack1 = buildStack(l1);
  Stack<Integer> stack2 = buildStack(l2);
  stack2 = buildStack(l2);
  int carry = 0;
  ListNode head = new ListNode(-1);
  while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
   int x = stack1.isEmpty() ? 0 : stack1.pop();
   int y = stack2.isEmpty() ? 0 : stack2.pop();
   int sum = x + y + carry;
   carry = sum / 10;
   ListNode node = new ListNode(sum % 10);
   node.next = head.next;
   head.next = node;

  }
  return head.next;

 }

 private Stack<Integer> buildStack(ListNode l) {
  Stack<Integer> stack = new Stack<>();
  while (l != null) {
   stack.push(l.val);
   l = l.next;
  }
  return stack;
 }
}
// @lc code=end
// 利用栈实现从个位开始相加，以及从个位开始建立链表的效果
