import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 *
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (55.45%)
 * Likes:    2933
 * Dislikes: 147
 * Total Accepted:    424.6K
 * Total Submissions: 763.1K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any
 * order.
 * 
 * A leaf is a node with no children.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1]
 * Output: ["1"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        backTracking(root, paths, values);
        return paths;
    }

    private void backTracking(TreeNode root, List<String> paths, List<Integer> values) {
        if (root == null) {
            return;
        }
        values.add(root.val);
        if (!isLeaf(root)) {
            backTracking(root.left, paths, values);
            backTracking(root.right, paths, values);
        } else {
            paths.add(buildPath(values));
        }
        values.remove(values.size() - 1);
    }

    private boolean isLeaf(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return true;
        }
        return false;
    }

    private String buildPath(List<Integer> values) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            str.append(values.get(i));
            if (i != values.size() - 1) {
                str.append("->");
            }
        }
        return str.toString();
    }
}
// @lc code=end
// 值不会是null的，为null的是TreeNode
