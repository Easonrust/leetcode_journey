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
// res[0] sum; res[1]: num
class Solution {
    public int count;

    public int averageOfSubtree(TreeNode root) {
        count = 0;
        dfs(root);
        return count;
    }

    public int[] dfs(TreeNode node) {
        int[] res = new int[2];
        if (node == null) {
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        int[] leftArr = dfs(node.left);
        int[] rightArr = dfs(node.right);
        res[0] = leftArr[0] + rightArr[0] + node.val;
        res[1] = leftArr[1] + rightArr[1] + 1;
        if (res[0] / res[1] == node.val) {
            count++;
        }
        return res;
    }
}
