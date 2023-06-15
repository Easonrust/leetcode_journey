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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int maxSum = Integer.MIN_VALUE;
        int step = 0;
        int res = -1;
        q.offer(root);
        while(!q.isEmpty()){
            int sz = q.size();
            int sum = 0;
            for(int i=0; i<sz; ++i){
                TreeNode cur = q.poll();
                sum += cur.val;
                if(cur.left!=null){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }
            }
            step++;
            if(sum>maxSum){
                res = step;
                maxSum = sum;
            }
        }
        return res;
    }
}