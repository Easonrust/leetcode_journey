/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
 List<Integer> list = new ArrayList<>();

 public boolean isValidBST(TreeNode root) {
  inOrder(root);
  for (int i = 0; i < list.size() - 1; ++i) {
   if (!(list.get(i) < list.get(i + 1))) {
    return false;
   }
  }

  return true;
 }

 public void inOrder(TreeNode root) {
  if (root == null) {
   return;
  }
  inOrder(root.left);
  list.add(root.val);
  inOrder(root.right);
 }
}

// 判断一棵树是否是二叉搜索树最简单的方法就是对他进行中序遍历，查看是否是有序的
// @lc code=end
