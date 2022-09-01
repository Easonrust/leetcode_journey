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
    int res = 1;
    public int goodNodes(TreeNode root) {
        dfs(root.left, root.val);
        dfs(root.right, root.val);
        return res;
    }
    
    private void dfs(TreeNode node, int maxVal) {
        if(node==null){
            return;
        }
        
        if(node.val>=maxVal){
            maxVal = node.val;
            res++;
        }
        
        dfs(node.left, maxVal);
        dfs(node.right, maxVal);
    }
}
