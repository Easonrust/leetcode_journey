class Solution {
 public int minTotalDistance(int[][] grid) {
  List<Integer> rows = new ArrayList<>();
  List<Integer> cols = new ArrayList<>();

  for (int i = 0; i < grid.length; ++i) {
   for (int j = 0; j < grid[0].length; ++j) {
    if (grid[i][j] == 1) {
     rows.add(i);
     cols.add(j);
    }
   }
  }

  int row = rows.get(rows.size() / 2);

  // 依据上述循环无法保证cols也是有序的，因此要额外进行排序
  Collections.sort(cols);
  int col = cols.get(cols.size() / 2);

  return getMinDistance(rows, row) + getMinDistance(cols, col);

 }

 private int getMinDistance(List<Integer> list, int mid) {
  int res = 0;
  for (int pos : list) {
   res += Math.abs(pos - mid);
  }

  return res;
 }
}

// index 横竖取中点处，这样可以两两配对，使距离最小
