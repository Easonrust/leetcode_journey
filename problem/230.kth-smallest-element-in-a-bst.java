/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 *
 * algorithms
 * Medium (64.10%)
 * Likes:    4572
 * Dislikes: 96
 * Total Accepted:    593.3K
 * Total Submissions: 920.9K
 * Testcase Example:  '[3,1,4,null,2]\n1'
 *
 * Given the root of a binary search tree, and an integer k, return the k^th
 * (1-indexed) smallest element in the tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 10^4
 * 0 <= Node.val <= 10^4
 * 
 * 
 * 
 * Follow up: If the BST is modified often (i.e., we can do insert and delete
 * operations) and you need to find the kth smallest frequently, how would you
 * optimize?
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
 private int cnt = 0;
 private int val = 0;

 public int kthSmallest(TreeNode root, int k) {
  inOrder(root, k);
  return val;
 }

 private void inOrder(TreeNode root, int k) {
  if (root == null) {
   return;
  }
  inOrder(root.left, k);
  cnt++;
  if (cnt == k) {
   val = root.val;
  }
  inOrder(root.right, k);
 }
}
// @lc code=end
// 对二叉查找树BST进行遍历，得到的结果是有序的
