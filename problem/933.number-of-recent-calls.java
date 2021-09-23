import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=933 lang=java
 *
 * [933] Number of Recent Calls
 */

// @lc code=start
class RecentCounter {
 private Deque<Integer> q;

 public RecentCounter() {
  q = new ArrayDeque<>();
 }

 public int ping(int t) {
  q.offer(t);
  while (q.peek() < t - 3000) {
   q.poll();
  }
  return q.size();
 }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter(); int param_1 = obj.ping(t);
 */
// @lc code=end
// 可以用队列实现。每次将 t 进入队尾，同时从队头开始依次移除小于 t-3000 的元素。然后返回队列的大小 q.size() 即可。
