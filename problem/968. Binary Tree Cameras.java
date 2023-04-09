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
    public int minCameraCover(TreeNode root) {
        int[] res = dfs(root);
        return res[1];
    }

    private int[] dfs(TreeNode node) {
        if(node==null){
            return new int[] {2000, 0, 0};
        }
        int[] res = new int[3];
        int[] leftArr = dfs(node.left);
        int[] rightArr = dfs(node.right);

        res[0] = leftArr[2] + rightArr[2] + 1;
        res[1] = Math.min(res[0], Math.min(leftArr[0]+rightArr[1], leftArr[1]+rightArr[0]));
        res[2] = Math.min(res[0], leftArr[1]+rightArr[1]);
        return res;
    }
}