class Solution {
 public int shortestDistance(int[][] grid) {
  int m = grid.length;
  int n = grid[0].length;
  int res = Integer.MAX_VALUE;
  int houseNum = 0;

  for (int i = 0; i < m; ++i) {
   for (int j = 0; j < n; ++j) {
    if (grid[i][j] == 1) {
     houseNum++;
    }
   }
  }

  for (int i = 0; i < m; ++i) {
   for (int j = 0; j < n; ++j) {
    if (grid[i][j] == 0) {
     res = Math.min(res, bfs(grid, i, j, houseNum));
    }
   }
  }

  if (res == Integer.MAX_VALUE) {
   return -1;
  }

  return res;
 }

 private int bfs(int[][] grid, int x, int y, int houseNum) {
  int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  int m = grid.length;
  int n = grid[0].length;
  int sum = 0;
  int cnt = 0;
  int step = 0;
  boolean[][] visited = new boolean[m][n];

  Queue<int[]> queue = new LinkedList<>();
  queue.add(new int[] { x, y });
  visited[x][y] = true;

  while (!queue.isEmpty()) {
   int size = queue.size();

   while (size-- > 0) {
    int[] cur = queue.poll();
    if (grid[cur[0]][cur[1]] == 1) {
     cnt++;
     sum += step;

     // 防止从房子上越过
     continue;
    }

    for (int[] d : direction) {
     int nx = cur[0] + d[0];
     int ny = cur[1] + d[1];
     if (nx >= 0 && nx < m && ny >= 0 && ny < n && visited[nx][ny] == false && grid[nx][ny] != 2) {
      visited[nx][ny] = true;
      queue.add(new int[] { nx, ny });
     }
    }

   }

   step++;
  }

  if (cnt != houseNum) {
   // 如果从该点没能到达所有房子，那么该点能到达的所有点也不可能，将它们设置为2
   for (int i = 0; i < m; ++i) {
    for (int j = 0; j < n; ++j) {
     if (grid[i][j] == 0 && visited[i][j] == true) {
      grid[i][j] = 2;
     }
    }
   }

   return Integer.MAX_VALUE;
  }

  return sum;
 }

}

// BFS 注意去重，以及visited数组的位置
