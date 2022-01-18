/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
 int res = 0;

 public int longestConsecutive(TreeNode root) {
  dfs(root);
  return res;
 }

 public int dfs(TreeNode root) {
  if (root == null) {
   return 0;
  }
  int left = 1;
  int right = 1;
  if (root.left == null || root.val == root.left.val - 1) {
   left = dfs(root.left) + 1;
  } else {
   dfs(root.left);
  }

  if (root.right == null || root.val == root.right.val - 1) {
   right = dfs(root.right) + 1;
  } else {
   dfs(root.right);
  }

  res = Math.max(res, Math.max(left, right));

  return Math.max(left, right);
 }
}

// dfs