/*
 * @lc app=leetcode id=814 lang=java
 *
 * [814] Binary Tree Pruning
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
 public TreeNode pruneTree(TreeNode root) {
  // base case
  if (root == null) {
   return null;
  }
  root.left = pruneTree(root.left);
  root.right = pruneTree(root.right);

  if (root.left == null && root.right == null) {
   if (root.val != 1) {
    return null;
   }
  }

  return root;

 }
}
// @lc code=end
