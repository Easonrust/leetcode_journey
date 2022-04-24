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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int maxIdx = -1;
        int maxVal = -1;
        for (int i = start; i <= end; ++i) {
            if (maxVal < nums[i]) {
                maxIdx = i;
                maxVal = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = buildTree(nums, start, maxIdx - 1);
        root.right = buildTree(nums, maxIdx + 1, end);
        return root;
    }
}