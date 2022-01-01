class Solution {
 int INF = 2147483647;
 int m;
 int n;
 int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

 public void wallsAndGates(int[][] rooms) {
  m = rooms.length;
  n = rooms[0].length;
  int[] start = new int[2];

  for (int i = 0; i < m; ++i) {
   for (int j = 0; j < n; ++j) {
    if (rooms[i][j] == INF) {
     start[0] = i;
     start[1] = j;
     boolean[][] visited = new boolean[m][n];
     rooms[i][j] = bfs(start, rooms, visited);
    }
   }
  }
 }

 private int bfs(int[] start, int[][] rooms, boolean[][] visited) {
  int res = 0;
  Queue<int[]> queue = new LinkedList<>();
  queue.add(start);
  visited[start[0]][start[1]] = true;

  while (!queue.isEmpty()) {
   int s = queue.size();
   while (s-- > 0) {
    int[] cur = queue.poll();
    if (rooms[cur[0]][cur[1]] == 0) {
     return res;
    }

    for (int[] d : direction) {
     int nextX = cur[0] + d[0];
     int nextY = cur[1] + d[1];
     if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && visited[nextX][nextY] == false
       && rooms[nextX][nextY] != -1) {
      queue.offer(new int[] { nextX, nextY });
      visited[nextX][nextY] = true;
     }
    }

   }
   res++;
  }

  return rooms[start[0]][start[1]];
 }
}

// bfs