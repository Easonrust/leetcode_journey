class Solution {
 public int minSwaps(int[] data) {
  int total = 0;
  for (int i : data) {
   total += i;
  }
  int cnt = 0;
  int l = 0;
  int r = 0;
  int maxCnt = 0;
  while (r < data.length) {
   cnt += data[r];
   r++;

   if (r - 1 - l + 1 > total) {
    cnt -= data[l];
    l++;
   }

   maxCnt = Math.max(maxCnt, cnt);
  }

  return total - maxCnt;
 }
}
// 先计算一共有多少1，然后算大小为总共1的个数的窗口最多能框住多少个1，然后做减法
// sliding window