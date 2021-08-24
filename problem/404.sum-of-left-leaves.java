/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
 *
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (52.80%)
 * Likes:    2183
 * Dislikes: 195
 * Total Accepted:    267.9K
 * Total Submissions: 505.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given the root of a binary tree, return the sum of all left leaves.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 24
 * Explanation: There are two left leaves in the binary tree, with values 9 and
 * 15 respectively.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 1000].
 * -1000 <= Node.val <= 1000
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
 public int sumOfLeftLeaves(TreeNode root) {
  if (root == null) {
   return 0;
  }

  // 这里因为判断自己是否是左节点很麻烦，所以判断自己的左节点
  if (isLeaf(root.left)) {
   return root.left.val + sumOfLeftLeaves(root.right);
  }
  return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
 }

 private boolean isLeaf(TreeNode root) {
  if (root == null) {
   return false;
  }
  return root.left == null && root.right == null;
 }
}
// @lc code=end
