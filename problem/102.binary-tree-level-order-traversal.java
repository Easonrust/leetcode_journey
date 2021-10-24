/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
 public List<List<Integer>> levelOrder(TreeNode root) {
  List<List<Integer>> res = new ArrayList<>();
  if (root == null) {
   return res;
  }
  Queue<TreeNode> q = new LinkedList<>();
  q.add(root);
  while (!q.isEmpty()) {
   int size = q.size();
   List<Integer> temp = new ArrayList<>();
   while (size-- > 0) {
    TreeNode node = q.poll();
    temp.add(node.val);
    if (node.left != null) {
     q.add(node.left);
    }
    if (node.right != null) {
     q.add(node.right);
    }
   }
   res.add(temp);

  }
  return res;
 }
}

// 单纯的BFS
// @lc code=end
