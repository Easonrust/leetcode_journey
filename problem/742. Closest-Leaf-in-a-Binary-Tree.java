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
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(graph, root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        for (TreeNode node : graph.keySet()) {
            if (node != null && node.val == k) {
                queue.add(node);
                visited.add(node);
            }
        }

        while (!queue.isEmpty()) {
            int s = queue.size();
            while (s-- > 0) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    if (graph.get(cur).size() == 1) {
                        return cur.val;
                    }

                    for (TreeNode next : graph.get(cur)) {
                        if (!visited.contains(next)) {
                            queue.add(next);
                            visited.add(next);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public void buildGraph(Map<TreeNode, List<TreeNode>> graph, TreeNode child, TreeNode parent) {
        if (child != null) {
            if (!graph.containsKey(child)) {
                graph.put(child, new ArrayList<TreeNode>());
            }
            if (!graph.containsKey(parent)) {
                graph.put(parent, new ArrayList<TreeNode>());
            }
            graph.get(child).add(parent);
            graph.get(parent).add(child);

            buildGraph(graph, child.left, child);
            buildGraph(graph, child.right, child);
        }
    }
}

// 将树用dfs转换为图，然后用bfs解决
