/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 * public int get(int row, int col) {}
 * public List<Integer> dimensions {}
 * };
 */

class Solution {
 public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
  int rows = binaryMatrix.dimensions().get(0);
  int cols = binaryMatrix.dimensions().get(1);
  int res = cols;
  for (int i = 0; i < rows; ++i) {
   int l = 0;
   int h = cols - 1;
   while (l < h) {
    int mid = l + (h - l) / 2;
    if (binaryMatrix.get(i, mid) == 1) {
     h = mid;
    } else {
     l = mid + 1;
    }
   }
   if (binaryMatrix.get(i, l) == 1) {
    res = Math.min(res, l);
   }
  }

  return res == cols ? -1 : res;
 }
}

// 找到在由每行第一个1的index组成的set中最小的index
