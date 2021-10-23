/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
  List<List<Integer>> res = new ArrayList<>();
  if (root == null) {
   return res;
  }
  Queue<TreeNode> q = new LinkedList<>();
  q.add(root);
  int level = 1;
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
   if (level % 2 != 0) {
    res.add(temp);
   } else {
    List<Integer> temp2 = new ArrayList<>();
    for (int i = temp.size() - 1; i >= 0; --i) {
     temp2.add(temp.get(i));
    }
    res.add(temp2);
   }
   level += 1;
  }
  return res;
 }
}

// 比较简单的BFS，没有什么花样
// @lc code=end
