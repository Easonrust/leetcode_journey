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
 public List<List<Integer>> verticalOrder(TreeNode root) {
  List<List<Integer>> res = new ArrayList<>();
  if (root == null) {
   return res;
  }

  Map<Integer, List<Integer>> colMap = new HashMap<>();
  Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
  Pair<TreeNode, Integer> start = new Pair<>(root, 0);
  queue.offer(start);
  while (!queue.isEmpty()) {
   int size = queue.size();
   while (size-- > 0) {
    Pair<TreeNode, Integer> cur = queue.poll();
    TreeNode node = cur.getKey();
    int col = cur.getValue();
    List<Integer> list = new ArrayList<>();
    if (colMap.containsKey(col)) {
     list = colMap.get(col);
    }
    list.add(node.val);
    colMap.put(col, list);
    if (node.left != null) {
     queue.add(new Pair<TreeNode, Integer>(node.left, col - 1));
    }
    if (node.right != null) {
     queue.add(new Pair<TreeNode, Integer>(node.right, col + 1));
    }
   }
  }
  List<Integer> sortedKeys = new ArrayList<>();
  for (int key : colMap.keySet()) {
   sortedKeys.add(key);
  }
  Collections.sort(sortedKeys);
  for (int key : sortedKeys) {
   res.add(colMap.get(key));
  }

  return res;
 }
}

// 使用BFS和hashmap，给每个col映射上号码，root处为col 0