import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
 public boolean canFinish(int numCourses, int[][] prerequisites) {

  // 用于标记当前节点是否被访问过了，减小运算量
  boolean[] globalMarked = new boolean[numCourses];

  // 用于标记在本次递归中节点是否被访问过了，从而判断图中是否存在环
  boolean[] localMarked = new boolean[numCourses];

  List<Integer>[] graph = new List[numCourses];

  for (int i = 0; i < numCourses; ++i) {
   graph[i] = new ArrayList<>();
  }
  for (int[] pre : prerequisites) {
   graph[pre[0]].add(pre[1]);
  }
  for (int i = 0; i < numCourses; ++i) {
   if (hasCycle(globalMarked, localMarked, i, graph)) {
    return false;
   }
  }
  return true;
 }

 private boolean hasCycle(boolean[] globalMarked, boolean[] localMarked, int curNode, List<Integer>[] graph) {
  if (localMarked[curNode]) {
   return true;
  }
  if (globalMarked[curNode]) {
   return false;
  }
  localMarked[curNode] = true;
  globalMarked[curNode] = true;
  for (int nextNode : graph[curNode]) {
   if (hasCycle(globalMarked, localMarked, nextNode, graph)) {
    return true;
   }
  }

  // 回溯
  localMarked[curNode] = false;
  return false;
 }
}
// @lc code=end
// 本题中判断有向图中是否存在环即可
