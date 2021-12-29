class Solution {
 public int minKnightMoves(int x, int y) {
  int[][] directions = { { -2, 1 }, { -2, -1 }, { 2, 1 }, { 2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 } };

  Deque<int[]> queue = new ArrayDeque<>();
  boolean[][] visited = new boolean[700][700];
  visited[0 + 350][0 + 350] = true;
  int[] start = { 0, 0 };
  queue.offer(start);
  int move = 0;
  while (!queue.isEmpty()) {
   int s = queue.size();
   while (s-- > 0) {
    int[] cur = queue.poll();
    if (cur[0] == x && cur[1] == y) {
     return move;
    }
    for (int[] d : directions) {
     int[] next = new int[2];
     next[0] = cur[0] + d[0];
     next[1] = cur[1] + d[1];
     if (visited[next[0] + 350][next[1] + 350] == false) {
      queue.offer(next);
      visited[next[0] + 350][next[1] + 350] = true;
     }

    }

   }
   move += 1;
  }

  return -1;

 }
}

// BFS