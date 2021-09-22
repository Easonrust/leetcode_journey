import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import javax.swing.tree.TreeNode;

import apple.laf.JRSUIUtils.Tree;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
 public List<Integer> rightSideView(TreeNode root) {
  if (root == null) {
   return Collections.emptyList();
  }
  List<Integer> res = new ArrayList<>();
  Deque<TreeNode> q = new ArrayDeque<>();
  q.offer(root);
  while (!q.isEmpty()) {
   int size = q.size();

   // res中只加入每次层次遍历中最右侧的元素
   res.add(q.peek().val);

   while (size > 0) {
    TreeNode node = q.poll();
    if (node.right != null) {
     q.offer(node.right);
    }
    if (node.left != null) {
     q.offer(node.left);
    }
    size--;
   }
  }
  return res;
 }
}
// @lc code=end
