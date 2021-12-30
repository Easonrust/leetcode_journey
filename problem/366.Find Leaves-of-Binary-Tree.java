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
 List<List<Integer>> res;
 Map<Integer, List<Integer>> map;

 public List<List<Integer>> findLeaves(TreeNode root) {
  res = new ArrayList<>();
  map = new HashMap<>();
  int cnt = 1;
  while (!checkLeave(root)) {
   List<Integer> list = new ArrayList<>();
   dfs(root, cnt, list);
   res.add(list);
   cnt++;
  }
  List<Integer> list = new ArrayList<>();
  list.add(root.val);
  res.add(list);

  return res;
 }

 private void dfs(TreeNode node, int cnt, List<Integer> list) {
  if (node == null) {
   return;
  }

  TreeNode left = node.left;
  if (checkLeave(left)) {
   list.add(left.val);
   node.left = null;
  } else {
   dfs(left, cnt, list);
  }

  TreeNode right = node.right;
  if (checkLeave(right)) {
   list.add(right.val);
   node.right = null;
  } else {
   dfs(right, cnt, list);
  }
 }

 private boolean checkLeave(TreeNode node) {
  if (node == null || node.left != null || node.right != null) {
   return false;
  }
  return true;
 }
}

// 没必要用map记录list