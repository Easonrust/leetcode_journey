/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = Integer.MAX_VALUE;
    int prev = -100000;
    public int minDiffInBST(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if(root==null){
            return;
        }
        traverse(root.left);
        res = Math.min(res, root.val-prev);
        prev = root.val;
        traverse(root.right);
    }
}