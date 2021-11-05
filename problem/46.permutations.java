import java.util.ArrayList;
import java.util.List;

class Solution {
 List<List<Integer>> res;

 public List<List<Integer>> permute(int[] nums) {
  res = new ArrayList<>();
  int n = nums.length;
  List<Integer> list = new ArrayList<>();
  boolean[] visited = new boolean[nums.length];
  backTracking(visited, nums, n, list);
  return res;
 }

 void backTracking(boolean[] visited, int[] nums, int n, List<Integer> list) {
  if (list.size() == n) {
   // 注意这里不能直接res.add(list)，而是应该定义一个新的对象
   res.add(new ArrayList<>(list));
   return;
  }

  for (int i = 0; i < nums.length; ++i) {
   if (visited[i] == true) {
    continue;
   }
   visited[i] = true;
   list.add(nums[i]);
   backTracking(visited, nums, n, list);
   list.remove(list.size() - 1);
   visited[i] = false;
  }
 }
}

// backtracking review
