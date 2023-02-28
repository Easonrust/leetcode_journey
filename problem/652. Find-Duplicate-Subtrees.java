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
    Map<String, Integer> map;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        res = new ArrayList<>();
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        if(root==null){
            return "#";
        }
        String leftStr = traverse(root.left);
        String rightStr = traverse(root.right);
        String curStr = leftStr + "," + rightStr + "," + String.valueOf(root.val);
        if(map.containsKey(curStr)&&map.get(curStr)==1){
            res.add(root);
        }
        map.put(curStr, map.getOrDefault(curStr, 0)+1);
        return curStr;
    }
}