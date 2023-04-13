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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L,1);
        return dfs(root, 0, targetSum, prefix);
    }

    private int dfs(TreeNode node, long curSum, int targetSum, Map<Long, Integer> prefix) {
        if(node==null){
            return 0;
        }

        curSum += node.val;
        int res = prefix.getOrDefault(curSum-targetSum, 0);
        prefix.put(curSum, prefix.getOrDefault(curSum, 0)+1);
        res += dfs(node.left, curSum, targetSum, prefix);
        res += dfs(node.right, curSum, targetSum, prefix);
        prefix.put(curSum, prefix.get(curSum)-1);
        return res;
    }
}