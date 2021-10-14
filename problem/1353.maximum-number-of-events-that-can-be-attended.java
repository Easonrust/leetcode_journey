/*
 * @lc app=leetcode id=1353 lang=java
 *
 * [1353] Maximum Number of Events That Can Be Attended
 */

// @lc code=start
class Solution {
 public int maxEvents(int[][] events) {
  Arrays.sort(events, new Comparator<>() {
   @Override
   public int compare(int[] o1, int[] o2) {
    if (o1[0] != o2[0]) {
     return o1[0] - o2[0];
    } else {
     return o1[1] - o2[1];
    }
   }
  });
  int cnt = 0;
  int j = 0;
  PriorityQueue<Integer> pq = new PriorityQueue<>();
  for (int i = 1; i <= 100001; ++i) {

   // 向队列中加入可以开始加入的活动
   while (j < events.length && events[j][0] == i) {
    pq.add(events[j][1]);
    j++;
   }

   // 把过期的活动全部剔除
   while (!pq.isEmpty() && i > pq.peek()) {
    pq.poll();
   }

   // 在没过期的活动中选择一个结束时间最早的活动加入
   if (!pq.isEmpty()) {
    cnt++;
    pq.poll();
   }
  }
  return cnt;
 }
}
// @lc code=end
