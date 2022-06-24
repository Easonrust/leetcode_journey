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
    int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }
    
    private void inOrder(TreeNode node, int k){
        if(node==null){
            return;
        }
        
        inOrder(node.left, k);
        
        rank++;
        if(rank==k){
            res = node.val;
            return;
        }
        
        inOrder(node.right,k);
    }
}