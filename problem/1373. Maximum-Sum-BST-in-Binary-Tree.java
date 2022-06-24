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
    int res = 0;
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return res;
    }
    
    private int[] traverse(TreeNode root){
        // max min sum
        if(root==null){
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        int maxVal = 0;
        int minVal = 0;
        int sum = 0;
        if(left!=null&&right!=null&&root.val>left[0]&&root.val<right[1]){
            maxVal = Math.max(right[0], root.val);
            minVal = Math.min(left[1], root.val);
            sum = left[2] + root.val + right[2];
            res = Math.max(res, sum);
        }else{
            return null;
        }
        return new int[]{maxVal, minVal, sum};
    }
}
