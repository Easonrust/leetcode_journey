/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
 public ListNode insertionSortList(ListNode head) {
  if (head == null || head.next == null) {
   return head;
  }
  ListNode dummy = new ListNode(head.val);
  ListNode cur = head;
  ListNode pre = dummy;
  dummy.next = head;
  while (cur != null) {

   // 说明当前链尾pre和cur的相对位置是正常的，比较下一组队尾
   if (pre.val <= cur.val) {
    pre = cur;
    cur = cur.next;
    continue;
   }

   // 不正常的情况将cur插入到正常的位置
   ListNode p = dummy;
   while (p.next.val <= cur.val) {
    p = p.next;
   }

   // 得到的p是大于cur的最小值
   ListNode t = cur.next;
   cur.next = p.next;
   p.next = cur;

   // 比较队尾和下一个元素
   pre.next = t;
   cur = t;
  }
  return dummy.next;
 }
}
// @lc code=end
// 遍历链表，每次将遍历到的结点 cur 与前一个结点 pre 进行值比较：

// 若结点 cur 的值比 pre 的大，说明当前 cur 已在正确的位置，直接往下遍历。
// 否则，从链表第一个结点开始遍历，将结点 cur 插入到正确的位置。
// 依次遍历，直至 cur 指向空，遍历结束。
