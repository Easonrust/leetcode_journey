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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newLeft = new TreeNode(val);
            newLeft.left = root;
            return newLeft;
        }
        dfs(root, 1, val, depth);
        return root;
    }
    
    private void dfs(TreeNode root, int curDepth, int val, int depth) {
        if(root==null){
            return;
        }
        if(curDepth==depth-1){
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);
            newLeft.left = root.left;
            newRight.right = root.right;
            root.left = newLeft;
            root.right = newRight;
        }else{
            dfs(root.left, curDepth+1, val, depth);
            dfs(root.right, curDepth+1, val, depth);
        }
    }
}
