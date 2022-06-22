/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
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

    public String traverse(TreeNode node) {
        if (node == null) {
            return "#";
        }

        String left = traverse(node.left);
        String right = traverse(node.right);
        String treeStr = left + "," + right + "," + node.val;
        int freq = map.getOrDefault(treeStr, 0);
        if (freq == 1) {
            res.add(node);
        }

        map.put(treeStr, freq + 1);
        return treeStr;
    }
}
