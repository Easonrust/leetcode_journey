import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
 private List<Integer> res;

 public List<Integer> spiralOrder(int[][] matrix) {
  res = new ArrayList<>();
  int i1 = 0, i2 = matrix.length - 1;
  int j1 = 0, j2 = matrix[0].length - 1;
  while (i1 <= i2 && j1 <= j2) {
   add(matrix, i1++, i2--, j1++, j2--);
  }
  return res;
 }

 private void add(int[][] matrix, int i1, int i2, int j1, int j2) {
  if (i1 == i2) {
   for (int j = j1; j <= j2; ++j) {
    res.add(matrix[i1][j]);
   }
   return;
  }
  if (j1 == j2) {
   for (int i = i1; i <= i2; ++i) {
    res.add(matrix[i][j1]);
   }
   return;
  }

  for (int j = j1; j < j2; ++j) {
   res.add(matrix[i1][j]);
  }

  for (int i = i1; i < i2; ++i) {
   res.add(matrix[i][j2]);
  }

  for (int j = j2; j > j1; --j) {
   res.add(matrix[i2][j]);
  }

  for (int i = i2; i > i1; --i) {
   res.add(matrix[i][j1]);
  }

  return;
 }
}
// @lc code=end
// 从外往里一圈一圈遍历并存储矩阵元素即可。
