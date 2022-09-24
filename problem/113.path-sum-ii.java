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
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return res;
        }
        track.add(root.val);
        backTracking(root, targetSum);
        track.remove(track.size()-1);
        return res;
    }
    
    private void backTracking(TreeNode root, int targetSum) {
        if(root.left==null&&root.right==null){
            if(root.val==targetSum){
                res.add(new ArrayList<>(track));
            }
            return;
        }
        
        targetSum -= root.val;
        
        if(root.left!=null){
            track.add(root.left.val);
            backTracking(root.left, targetSum);
            track.remove(track.size()-1);
        }
        
        if(root.right!=null){
            track.add(root.right.val);
            backTracking(root.right, targetSum);
            track.remove(track.size()-1);
        }
    }
}