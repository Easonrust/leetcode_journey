/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
class Solution {
 public List<List<Integer>> generate(int numRows) {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> firstRow = new ArrayList<>();
  firstRow.add(1);
  res.add(firstRow);
  for (int i = 1; i < numRows; ++i) {
   List<Integer> row = new ArrayList<>();
   for (int j = 0; j < i + 1; ++j) {
    int temp = (j - 1 >= 0 ? res.get(i - 1).get(j - 1) : 0) + (j <= i - 1 ? res.get(i - 1).get(j) : 0);
    row.add(temp);
   }

   res.add(row);
  }

  return res;

 }
}

// 在复杂表达式使用?时最好加括号
// @lc code=end
