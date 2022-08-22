/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean findP = false;
    boolean findQ = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = findNode(root, p, q);
        if(findP==false||findQ==false){
            return null;
        }
        return res;
    }
    
    private TreeNode findNode(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        
        TreeNode left = findNode(root.left, p, q);
        TreeNode right = findNode(root.right, p, q);
        
        if(root.val==p.val){
            findP = true;
            return root;
        }
        
        if(root.val==q.val){
            findQ = true;
            return root;
        }
        

        
        if(left!=null&&right!=null){
            return root;
        }
        
        if(left==null){
            return right;
        }
        
        return left;
    }
}