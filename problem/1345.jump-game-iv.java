/*
 * @lc app=leetcode id=1345 lang=java
 *
 * [1345] Jump Game IV
 */

// @lc code=start
class Solution {
 public int minJumps(int[] arr) {
  if (arr.length == 0) {
   return 0;
  }
  int res = 0;
  Map<Integer, List<Integer>> map = new HashMap<>();
  boolean[] marked = new boolean[arr.length];
  for (int i = 0; i < arr.length; ++i) {
   List<Integer> list = new ArrayList<>();
   if (map.containsKey(arr[i])) {
    list = map.get(arr[i]);
   }
   list.add(i);
   map.put(arr[i], list);
  }

  Queue<Integer> queue = new LinkedList<>();
  queue.add(0);
  while (!queue.isEmpty()) {
   int size = queue.size();
   while (size-- > 0) {
    int cur = queue.poll();
    marked[cur] = true;
    if (cur == arr.length - 1) {
     return res;
    }
    List<Integer> list = map.get(arr[cur]);
    for (int idx : list) {
     if (idx != cur && marked[idx] == false) {
      queue.add(idx);
     }
    }

    if (cur > 0 && marked[cur - 1] == false) {
     queue.add(cur - 1);
    }
    if (cur < arr.length - 1 && marked[cur + 1] == false) {
     queue.add(cur + 1);
    }
    list.clear();

   }
   res += 1;
  }
  return -1;

 }
}

// 这道题如果直接用邻接表做会超时，而且在bfs中创造的list要记得clear，否则会超出memory的限制
// @lc code=end
