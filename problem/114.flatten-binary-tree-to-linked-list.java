/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 */

// @lc code=start
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
 public void flatten(TreeNode root) {
  root = preOrder(root);
 }

 private TreeNode preOrder(TreeNode root) {
  if (root == null) {
   return null;
  }
  TreeNode node = root;
  TreeNode left = root.left;
  TreeNode right = root.right;
  node.left = null;
  node.right = preOrder(left);
  TreeNode temp = node;
  while (temp.right != null) {
   temp = temp.right;
  }
  temp.right = preOrder(right);

  return node;

 }
}
// @lc code=end
