class Solution {
 double max;

 public double maximumAverageSubtree(TreeNode root) {
  if (root == null) {
   return 0;
  }
  max = 0.0;
  int[] res = new int[2];
  res = dfs(root);
  return max;

 }

 public int[] dfs(TreeNode node) {
  int[] res = new int[2];
  if (node == null) {
   res[0] = 0;
   res[1] = 0;
   return res;
  }
  int[] resLeft = dfs(node.left);
  int[] resRight = dfs(node.right);
  int sum = resLeft[1] + resRight[1] + node.val;
  int num = resLeft[0] + resRight[0] + 1;
  res[0] = num;
  res[1] = sum;
  double average = (double) sum / (double) num;
  max = Math.max(max, average);
  return res;
 }
}
// dfs
// https://leetcode.com/problems/maximum-average-subtree/