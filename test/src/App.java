import java.util.*;

public class ListNode {
 int val;ListNode*next;

 ListNode() {
 }

 ListNode(int val) {
  this.val = val;
 }

 ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }

public class App {
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
  ListNode firstList = cut(head, second);
  ListNode secondList = null;
  if (first.next == null) {
   // 奇数
   secondList = reverse(second.next);
  } else if (first == null) {
   secondList = reverse(second);
   // 偶数
  }
  return isEqual(firstList, secondList);
 }

 private ListNode cut(ListNode head, ListNode second) {
  while (head.next != second) {
   head = head.next;
  }
  return head;
 }

 private ListNode reverse(ListNode second) {
  if (second.next == null) {
   return second;
  }
  ListNode newHead = new ListNode(-1);
  while (second.next != null) {
   ListNode l1 = second;
   ListNode l2 = second.next;
   l1.next = newHead.next;
   second = l2;
   l2.next = l1;
   newHead.next = l2;
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

 public static void main(String[] args) throws Exception {
  App app = new App();
  int[][] heights = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
  System.out.println(app.letterCombinations("29"));
 }
}
