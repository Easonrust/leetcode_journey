/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * algorithms
 * Easy (62.47%)
 * Likes:    4707
 * Dislikes: 305
 * Total Accepted:    606.5K
 * Total Submissions: 956.7K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * Given an integer array nums where the elements are sorted in ascending
 * order, convert it to a height-balanced binary search tree.
 * 
 * A height-balanced binary tree is a binary tree in which the depth of the two
 * subtrees of every node never differs by more than one.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in a strictly increasing order.
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
 public TreeNode sortedArrayToBST(int[] nums) {
  return toBST(nums, 0, nums.length - 1);
 }

 private TreeNode toBST(int[] nums, int low, int high) {
  if (low > high) {
   return null;
  }
  int mid = (low + high) / 2;
  TreeNode root = new TreeNode(nums[mid]);
  root.right = toBST(nums, mid + 1, high);
  root.left = toBST(nums, low, mid - 1);
  return root;
 }
}
// @lc code=end
// 根据有序数组构造二叉搜索树的方法和Binary Search有些类似
