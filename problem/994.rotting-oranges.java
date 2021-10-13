/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
 public int orangesRotting(int[][] grid) {
  Queue<Pair<Integer, Integer>> q = new LinkedList<>();
  int m = grid.length;
  int n = grid[0].length;
  for (int i = 0; i < m; ++i) {
   for (int j = 0; j < n; ++j) {
    if (grid[i][j] == 2) {
     q.add(new Pair<>(i, j));
    }
   }
  }

  int res = 0;
  if (q.size() == 0) {
   res = 1;
  }
  int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
  while (!q.isEmpty()) {
   int s = q.size();
   res++;
   while (s-- > 0) {
    Pair<Integer, Integer> p = q.poll();
    int r = p.getKey();
    int c = p.getValue();
    for (int[] d : direction) {
     int nr = r + d[0];
     int nc = c + d[1];
     if (nr >= 0 && nr <= m - 1 && nc >= 0 && nc <= n - 1 && grid[nr][nc] == 1) {
      grid[nr][nc] = 2;
      q.add(new Pair<>(nr, nc));
     }
    }

   }
  }
  for (int i = 0; i < m; ++i) {
   for (int j = 0; j < n; ++j) {
    if (grid[i][j] == 1) {
     return -1;
    }
   }
  }
  return res - 1;
 }
}
// @lc code=end
// BFS
