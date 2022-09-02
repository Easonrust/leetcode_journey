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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int sz = queue.size();
            double sum = 0;
            for(int i=0; i<sz; ++i){
                TreeNode cur = queue.removeFirst();
                sum += cur.val;
                if(cur.left!=null){
                    queue.addLast(cur.left);
                }
                if(cur.right!=null){
                    queue.addLast(cur.right);
                }
            }
            res.add(sum/(double)sz);
        }
        return res;
    }
}