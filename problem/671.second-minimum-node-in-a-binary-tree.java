/*
 * @lc app=leetcode id=671 lang=java
 *
 * [671] Second Minimum Node In a Binary Tree
 *
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
 *
 * algorithms
 * Easy (42.97%)
 * Likes:    944
 * Dislikes: 1228
 * Total Accepted:    112.9K
 * Total Submissions: 262.4K
 * Testcase Example:  '[2,2,5,null,null,5,7]'
 *
 * Given a non-empty special binary tree consisting of nodes with the
 * non-negative value, where each node in this tree has exactly two or zero
 * sub-node. If the node has two sub-nodes, then this node's value is the
 * smaller value among its two sub-nodes. More formally, the property root.val
 * = min(root.left.val, root.right.val) always holds.
 * 
 * Given such a binary tree, you need to output the second minimum value in the
 * set made of all the nodes' value in the whole tree.
 * 
 * If no such second minimum value exists, output -1 instead.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [2,2,5,null,null,5,7]
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [2,2,2]
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest
 * value.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 25].
 * 1 <= Node.val <= 2^31 - 1
 * root.val == min(root.left.val, root.right.val) for each internal node of the
 * tree.
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
 public int findSecondMinimumValue(TreeNode root) {

  // 变成-1的情况只能在等于根结点的一支出现
  if (root == null) {
   return -1;
  }
  if (root.left == null && root.right == null) {
   return -1;
  }

  // 后面去找的其实是最小的不等于根结点的子节点
  int leftVal = root.left.val;
  int rightVal = root.right.val;
  if (leftVal == root.val) {
   leftVal = findSecondMinimumValue(root.left);
  }
  if (rightVal == root.val) {
   rightVal = findSecondMinimumValue(root.right);
  }
  if (leftVal != -1 && rightVal != -1) {
   return Math.min(leftVal, rightVal);
  }
  if (leftVal != -1) {
   return leftVal;
  }
  return rightVal;

 }
}
// @lc code=end
// 理解了差不多
