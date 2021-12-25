class TicTacToe {
 int[][] board;
 int N;

 public TicTacToe(int n) {
  board = new int[n][n];
  N = n;
 }

 public int move(int row, int col, int player) {
  board[row][col] = player;
  if (checkRowWin(row, player) || checkColWin(col, player) || checkDia1Win(col, row, player)
    || checkDia2Win(col, row, player)) {
   return player;
  }
  return 0;
 }

 private boolean checkRowWin(int row, int player) {
  for (int j = 0; j < N; ++j) {
   if (board[row][j] != player) {
    return false;
   }
  }
  return true;
 }

 private boolean checkColWin(int col, int player) {
  for (int i = 0; i < N; ++i) {
   if (board[i][col] != player) {
    return false;
   }
  }
  return true;
 }

 private boolean checkDia1Win(int col, int row, int player) {
  if (col == row) {
   for (int i = 0; i < N; ++i) {
    if (board[i][i] != player) {
     return false;
    }
   }
  } else {
   return false;
  }
  return true;
 }

 private boolean checkDia2Win(int col, int row, int player) {
  if (N - col - 1 == row) {
   for (int i = 0; i < N; ++i) {
    if (board[i][N - i - 1] != player) {
     return false;
    }
   }
  } else {
   return false;
  }
  return true;
 }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */