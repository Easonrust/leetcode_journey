class Solution {
 public int getFood(char[][] grid) {
  int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
  int[] start = new int[2];
  int res = 0;
  for (int i = 0; i < grid.length; ++i) {
   for (int j = 0; j < grid[0].length; ++j) {
    if (grid[i][j] == '*') {
     start[0] = i;
     start[1] = j;
     break;
    }
   }
  }
  boolean[][] marked = new boolean[grid.length][grid[0].length];
  marked[start[0]][start[1]] = true;
  Queue<int[]> q = new LinkedList<>();
  q.offer(start);
  while (!q.isEmpty()) {
   int size = q.size();
   res += 1;
   while (size-- > 0) {
    int[] cur = q.poll();

    if (grid[cur[0]][cur[1]] == '#') {
     return res - 1;
    }

    for (int[] d : direction) {
     int nx = cur[0] + d[0];
     int ny = cur[1] + d[1];
     if (nx >= 0 && nx <= grid.length - 1 && ny >= 0 && ny <= grid[0].length - 1 && grid[nx][ny] != 'X'
       && marked[nx][ny] == false) {
      int[] next = new int[2];
      next[0] = nx;
      next[1] = ny;
      q.offer(next);
      marked[nx][ny] = true;
     }
    }

   }
  }
  return -1;
 }
}

// BFS, 注意要标记走过的点