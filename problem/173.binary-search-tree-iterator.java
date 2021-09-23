import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class BSTIterator {
 private int cur = 0;
 private List<Integer> vals = new ArrayList<>();

 public BSTIterator(TreeNode root) {
  inOrder(root);
 }

 public int next() {
  return vals.get(cur++);
 }

 public boolean hasNext() {
  return cur < vals.size();
 }

 private void inOrder(TreeNode node) {
  if (node != null) {
   inOrder(node.left);
   vals.add(node.val);
   inOrder(node.right);
  }
 }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */
// @lc code=end
// 对树进行中序遍历，并用一个链表存储遍历的值即可
