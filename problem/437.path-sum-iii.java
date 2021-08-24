/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii/description/
 *
 * algorithms
 * Medium (48.72%)
 * Likes:    5833
 * Dislikes: 329
 * Total Accepted:    292.1K
 * Total Submissions: 597.9K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * Given the root of a binary tree and an integer targetSum, return the number
 * of paths where the sum of the values along the path equals targetSum.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards (i.e., traveling only from parent nodes to child nodes).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 1000].
 * -10^9 <= Node.val <= 10^9
 * -1000 <= targetSum <= 1000
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
 public int pathSum(TreeNode root, int targetSum) {
  if (root == null) {
   return 0;
  }
  return pathSumAsRoot(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);

 }

 private int pathSumAsRoot(TreeNode root, int targetSum) {
  if (root == null) {
   return 0;
  }
  int ret = 0;
  if (targetSum == root.val) {
   ret++;
  }
  return ret + pathSumAsRoot(root.left, targetSum - root.val) + pathSumAsRoot(root.right, targetSum - root.val);
 }
}
// @lc code=end
// 因为路径的起点不一定是根结点，所以递归的方式有所差别
// 需要写成两个递归，从而达到每个结点都能作为起点
