import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
 private List<List<Integer>> res;
 private List<Integer> path;

 public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
  res = new ArrayList<>();
  path = new ArrayList<>();
  if (root == null) {
   return res;
  }
  dfs(root, targetSum);
  return res;
 }

 private void dfs(TreeNode root, int targetSum) {
  if (root == null) {
   return;
  }
  path.add(root.val);
  if (root.val == targetSum && root.right == null && root.left == null) {

   // 这里注意不能这样写，一定要定义一个新的arraylist
   // res.add(path);
   res.add(new ArrayList<>(path));
  }
  dfs(root.left, targetSum - root.val);
  dfs(root.right, targetSum - root.val);

  // 回溯
  path.remove(path.size() - 1);
 }
}
// @lc code=end
// 深度优先搜索加回溯
