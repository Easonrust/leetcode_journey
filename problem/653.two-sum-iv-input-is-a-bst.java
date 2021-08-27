import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=653 lang=java
 *
 * [653] Two Sum IV - Input is a BST
 *
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 *
 * algorithms
 * Easy (56.75%)
 * Likes:    2596
 * Dislikes: 173
 * Total Accepted:    236.7K
 * Total Submissions: 411.5K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n9'
 *
 * Given the root of a Binary Search Tree and a target number k, return true if
 * there exist two elements in the BST such that their sum is equal to the
 * given target.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [5,3,6,2,4,null,7], k = 9
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [5,3,6,2,4,null,7], k = 28
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [2,1,3], k = 4
 * Output: true
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: root = [2,1,3], k = 1
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: root = [2,1,3], k = 3
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 10^4].
 * -10^4 <= Node.val <= 10^4
 * root is guaranteed to be a valid binary search tree.
 * -10^5 <= k <= 10^5
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
 public boolean findTarget(TreeNode root, int k) {
  List<Integer> nums = new ArrayList<>();
  inOrder(root, nums);

  // 两数和问题牢记双指针法
  int i = 0;
  int j = nums.size() - 1;
  while (i < j) {
   int sum = nums.get(i) + nums.get(j);
   if (sum == k) {
    return true;
   }
   if (sum < k) {
    i++;
   }
   if (sum > k) {
    j--;
   }
  }
  return false;
 }

 private void inOrder(TreeNode root, List<Integer> nums) {
  if (root == null) {
   return;
  }
  inOrder(root.left, nums);
  nums.add(root.val);
  inOrder(root.right, nums);
 }
}
// @lc code=end
// 两数和问题牢记双指针法