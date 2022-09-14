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
    int[] count = new int[10];
    int res = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root);
        return res;
    }
    
    private void dfs(TreeNode root) {
        if(root==null){
            return;
        }
        
        if(root.left==null&&root.right==null){
            count[root.val]++;
            int odd = 0;
            for(int num:count){
                if(num%2!=0){
                    odd++;
                }
            }
            if(odd<=1){
                res++;
            }
            count[root.val]--;
            return;
        }
        
        count[root.val]++;
        dfs(root.left);
        dfs(root.right);
        count[root.val]--;
    }
}