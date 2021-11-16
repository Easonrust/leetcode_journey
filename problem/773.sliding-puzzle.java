/*
 * @lc app=leetcode id=773 lang=java
 *
 * [773] Sliding Puzzle
 */

// @lc code=start
class Solution {
 public int slidingPuzzle(int[][] board) {
  String target = "123450";
  String start = "";

  for (int i = 0; i < board.length; ++i) {
   for (int j = 0; j < board[0].length; ++j) {
    start += board[i][j];
   }
  }

  HashSet<String> visited = new HashSet<>();

  // 当0处于表格中6个不同位置时，下一步可以交换到的地方
  int[][] dirs = new int[][] { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
  Queue<String> queue = new LinkedList<>();
  queue.offer(start);

  // 防止重复
  visited.add(start);
  int step = 0;
  while (!queue.isEmpty()) {
   int size = queue.size();
   while (size-- > 0) {
    String cur = queue.poll();
    if (cur.equals(target)) {
     return step;
    }

    int zero = cur.indexOf('0');

    for (int dir : dirs[zero]) {
     String next = swap(cur, zero, dir);
     if (visited.contains(next)) {
      continue;
     }

     visited.add(next);
     queue.offer(next);
    }

   }
   step++;
  }

  return -1;

 }

 private String swap(String str, int i, int j) {
  StringBuilder sb = new StringBuilder(str);
  sb.setCharAt(i, str.charAt(j));
  sb.setCharAt(j, str.charAt(i));

  return sb.toString();
 }
}
// @lc code=end
