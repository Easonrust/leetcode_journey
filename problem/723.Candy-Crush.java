class Solution {
 int m, n;

 public int[][] candyCrush(int[][] board) {
  m = board.length;
  n = board[0].length;

  boolean end = false;

  while (!end) {
   boolean[][] crush = crushOp(board);
   end = true;
   for (int i = 0; i < m; ++i) {
    for (int j = 0; j < n; ++j) {
     if (crush[i][j]) {
      board[i][j] = 0;
      end = false;
     }
    }
   }
   if (end == false) {
    dropOp(board);
   }
  }

  return board;

 }

 private boolean[][] crushOp(int[][] board) {
  boolean[][] crush = new boolean[m][n];
  for (int i = 0; i < m; ++i) {
   for (int j = 1; j < n - 1; ++j) {
    if (board[i][j - 1] == board[i][j] && board[i][j + 1] == board[i][j] && board[i][j] != 0) {
     // mid of row pattern
     int color = board[i][j];
     crush[i][j] = true;
     for (int k = j - 1; k >= 0; k--) {
      if (board[i][k] != color) {
       break;
      }
      crush[i][k] = true;
     }

     for (int k = j + 1; k < n; k++) {
      if (board[i][k] != color) {
       break;
      }
      crush[i][k] = true;
     }
    }
   }
  }

  for (int j = 0; j < n; ++j) {
   for (int i = 1; i < m - 1; ++i) {
    if (board[i - 1][j] == board[i][j] && board[i + 1][j] == board[i][j] && board[i][j] != 0) {
     // mid of col pattern
     int color = board[i][j];
     crush[i][j] = true;
     for (int k = i - 1; k >= 0; k--) {
      if (board[k][j] != color) {
       break;
      }
      crush[k][j] = true;
     }

     for (int k = i + 1; k < m; k++) {
      if (board[k][j] != color) {
       break;
      }
      crush[k][j] = true;
     }
    }
   }
  }
  return crush;
 }

 private void dropOp(int[][] board) {
  for (int j = 0; j < n; ++j) {
   List<Integer> list = new ArrayList<>();
   int cnt = 0;
   for (int i = 0; i < m; ++i) {
    if (board[i][j] != 0) {
     list.add(board[i][j]);
    } else {
     cnt++;
    }
   }

   for (int i = 0; i < m; ++i) {
    if (i < cnt) {
     board[i][j] = 0;
    } else {
     board[i][j] = list.get(i - cnt);
    }
   }
  }
 }
}