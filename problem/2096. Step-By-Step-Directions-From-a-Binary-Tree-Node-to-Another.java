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
    StringBuilder start = new StringBuilder();
    StringBuilder dest = new StringBuilder();
    StringBuilder res = new StringBuilder();
    String startStr = "";
    String destStr = "";
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);
        dfs_start(lca, startValue);
        dfs_dest(lca, destValue);
        return startStr + destStr;
    }

    public void dfs_start(TreeNode node, int val) {
        if(node==null){
            return;
        }

        if(node.val==val){
            startStr = start.toString(); 
            return;
        }

        start.append("U");
        dfs_start(node.left, val);
        start.deleteCharAt(start.length()-1);

        start.append("U");
        dfs_start(node.right, val);
        start.deleteCharAt(start.length()-1);
    }

    public void dfs_dest(TreeNode node, int val) {
        if(node==null){
            return;
        }

        if(node.val==val){
            destStr = dest.toString(); 
            return;
        }

        dest.append("L");
        dfs_dest(node.left, val);
        dest.deleteCharAt(dest.length()-1);

        dest.append("R");
        dfs_dest(node.right, val);
        dest.deleteCharAt(dest.length()-1);
    }

    private TreeNode findLCA(TreeNode node, int val1, int val2) {
        if(node==null){
            return null;
        }

        if(node.val==val1||node.val==val2){
            return node;
        }

        TreeNode left = findLCA(node.left, val1, val2);
        TreeNode right = findLCA(node.right, val1, val2);
        if(left!=null&&right!=null){
            return node;
        }

        if(left==null){
            return right;
        }

        return left;
    }
}