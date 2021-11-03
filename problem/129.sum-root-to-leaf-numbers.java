/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
 int sum;

 public int sumNumbers(TreeNode root) {
  sum = 0;
  dfs(root, 0);
  return sum;
 }

 void dfs(TreeNode node, int num) {
  if (node == null) {
   return;
  }
  num = num * 10 + node.val;
  if (node.left == null && node.right == null) {
   sum += num;
   return;
  }

  dfs(node.left, num);
  dfs(node.right, num);
 }
}
// @lc code=end
// DFS, 注意node为null时就不构成path了
