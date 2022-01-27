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
    public TreeNode str2tree(String s) {
        Pair<TreeNode, Integer> res = recursion(s, 0);
        return res.getKey();
    }

    public int[] getNumber(String s, int index) {
        int isNegative = 1;

        if (s.charAt(index) == '-') {
            isNegative = -1;
            index++;
        }

        int num = 0;
        while (index < s.length() && s.charAt(index) != ')' && s.charAt(index) != '(') {
            int cur = s.charAt(index) - '0';
            num = (num * 10 + cur);
            index++;
        }

        // 此时的index 应该在）处 或者 index 已到s.length()
        int[] res = new int[2];
        res[0] = isNegative * num;
        res[1] = index;
        return res;
    }

    public Pair<TreeNode, Integer> recursion(String s, int index) {
        if (index == s.length()) {
            return new Pair<TreeNode, Integer>(null, 0);
        }

        int[] numIdx = getNumber(s, index);
        index = numIdx[1];
        TreeNode node = new TreeNode(numIdx[0]);

        if (index < s.length() && s.charAt(index) == '(') {
            Pair<TreeNode, Integer> leftNodeIdx = recursion(s, index + 1);
            node.left = leftNodeIdx.getKey();
            index = leftNodeIdx.getValue();
        }

        // 检查 node.left != null 避免重复计算
        if (node.left != null && index < s.length() && s.charAt(index) == '(') {
            Pair<TreeNode, Integer> rightNodeIdx = recursion(s, index + 1);
            node.right = rightNodeIdx.getKey();
            index = rightNodeIdx.getValue();
        }

        return new Pair<TreeNode, Integer>(node, index + 1);
    }
}

// recursion
