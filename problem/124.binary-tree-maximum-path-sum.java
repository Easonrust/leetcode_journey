/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
 public int res;

 public int maxPathSum(TreeNode root) {
  res = Integer.MIN_VALUE;
  dfs(root);
  return res;
 }

 public int dfs(TreeNode node) {
  if (node == null) {
   return 0;
  }

  int right = dfs(node.right);
  int left = dfs(node.left);

  if (right < 0) {
   right = 0;
  }

  if (left < 0) {
   left = 0;
  }

  int depth = Math.max(node.val + right, node.val + left);
  int curMax = right + node.val + left;
  res = Math.max(res, curMax);

  return depth;
 }
}

// 这种题在dfs里面，能用变量存函数结果就存，不要反复call，太花时间
// @lc code=end
