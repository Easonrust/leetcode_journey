/*
 * @lc app=leetcode id=1235 lang=java
 *
 * [1235] Maximum Profit in Job Scheduling
 */

// @lc code=start
class Solution {

 int[] memo = new int[50001];

 public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
  List<List<Integer>> jobs = new ArrayList<>();

  Arrays.fill(memo, -1);

  int n = profit.length;

  for (int i = 0; i < n; ++i) {
   List<Integer> curJob = new ArrayList<>();
   curJob.add(startTime[i]);
   curJob.add(endTime[i]);
   curJob.add(profit[i]);
   jobs.add(curJob);
  }

  Collections.sort(jobs, new Comparator<>() {
   @Override
   public int compare(List<Integer> o1, List<Integer> o2) {
    return o1.get(0) - o2.get(0);
   }
  });

  for (int i = 0; i < n; ++i) {
   startTime[i] = jobs.get(i).get(0);
  }

  return findMaxProfit(jobs, startTime, n, 0);
 }

 private int findMaxProfit(List<List<Integer>> jobs, int[] startTime, int n, int position) {

  // base case, 此时为从n到n的maxprofit为0
  if (position == n) {
   return 0;
  }

  // 如果不为-1，说明之前已经计算过了，直接返回
  if (memo[position] != -1) {
   return memo[position];
  }

  // 下一个不与当前job重合的job
  int nextIndex = findNextJob(startTime, jobs.get(position).get(1));

  // 不选当前的job，则为下一个index的值；选当前的job，则为当前的profit加上下一个不与当前重合的job的值
  int maxProfit = Math.max(findMaxProfit(jobs, startTime, n, position + 1),
    jobs.get(position).get(2) + findMaxProfit(jobs, startTime, n, nextIndex));

  memo[position] = maxProfit;

  return maxProfit;
 }

 // 二分查找找下一个不与i重合的job
 private int findNextJob(int[] startTime, int lastEndingTime) {
  int l = 0, h = startTime.length - 1;
  int res = startTime.length;
  while (l <= h) {
   int mid = l + (h - l) / 2;
   if (lastEndingTime <= startTime[mid]) {
    res = mid;
    h = mid - 1;
   } else {
    l = mid + 1;
   }
  }

  return res;
 }
}

// memo[i]中存储的是从i到末尾的最大profit和
// @lc code=end
