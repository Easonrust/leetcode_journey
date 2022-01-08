class Solution {
 public boolean hasPath(int[][] maze, int[] start, int[] destination) {
  int m = maze.length;
  int n = maze[0].length;
  boolean[][] visited = new boolean[m][n];
  Queue<int[]> queue = new LinkedList<>();
  int[][] directions = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
  queue.add(start);

  visited[start[0]][start[1]] = true;

  while (!queue.isEmpty()) {
   int size = queue.size();
   while (size-- > 0) {
    int[] cur = queue.poll();
    if (cur[0] == destination[0] && cur[1] == destination[1]) {
     return true;
    }

    for (int[] d : directions) {
     int nx = cur[0] + d[0];
     int ny = cur[1] + d[1];
     while (nx >= 0 && ny >= 0 && nx < m && ny < n && maze[nx][ny] == 0) {
      nx += d[0];
      ny += d[1];
     }
     if (visited[nx - d[0]][ny - d[1]] == false) {
      queue.add(new int[] { nx - d[0], ny - d[1] });
      visited[nx - d[0]][ny - d[1]] = true;
     }
    }
   }
  }

  return false;
 }
}

// BFS