import apple.laf.JRSUIUtils.Tree;

/*
 * @lc app=leetcode id=687 lang=java
 *
 * [687] Longest Univalue Path
 *
 * https://leetcode.com/problems/longest-univalue-path/description/
 *
 * algorithms
 * Medium (38.12%)
 * Likes:    2576
 * Dislikes: 579
 * Total Accepted:    123.4K
 * Total Submissions: 322.4K
 * Testcase Example:  '[5,4,5,1,1,5]'
 *
 * Given the root of a binary tree, return the length of the longest path,
 * where each node in the path has the same value. This path may or may not
 * pass through the root.
 * 
 * The length of the path between two nodes is represented by the number of
 * edges between them.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [5,4,5,1,1,5]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,4,5,4,4,5]
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 10^4].
 * -1000 <= Node.val <= 1000
 * The depth of the tree will not exceed 1000.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
 // 因为不一定包含根结点，所以这里定义一个全局变量
 private int maxPath = 0;

 public int longestUnivaluePath(TreeNode root) {
  dfs(root);
  return maxPath;
 }

 private int dfs(TreeNode root) {
  if (root == null) {
   return 0;
  }
  int left = dfs(root.left);
  int right = dfs(root.right);
  int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
  int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
  maxPath = Math.max(maxPath, leftPath + rightPath);

  // 因为一条path只能是一条线，所以这里返回的是最大值
  return Math.max(leftPath, rightPath);
 }
}
// @lc code=end
