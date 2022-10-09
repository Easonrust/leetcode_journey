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
    List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inOrder(root);
        int l = 0;
        int r = list.size()-1;
        while(l<r){
            int sum = list.get(l)+list.get(r);
            if(sum==k){
                return true;
            }else if(sum<k){
                l++;
            }else{
                r--;
            }
        }
        return false;
    }
    
    private void inOrder(TreeNode root) {
        if(root==null){
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
    
    
}