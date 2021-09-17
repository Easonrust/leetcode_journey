import java.util.Stack;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
 public int[] findOrder(int numCourses, int[][] prerequisites) {
  // 用于标记当前节点是否被访问过了，减小运算量
  boolean[] globalMarked = new boolean[numCourses];

  // 用于标记在本次递归中节点是否被访问过了，从而判断图中是否存在环
  boolean[] localMarked = new boolean[numCourses];

  Stack<Integer> postOrder = new Stack<>();

  List<Integer>[] graph = new List[numCourses];

  for (int i = 0; i < numCourses; ++i) {
   graph[i] = new ArrayList<>();
  }
  for (int[] pre : prerequisites) {
   graph[pre[0]].add(pre[1]);
  }
  for (int i = 0; i < numCourses; ++i) {

   // 存在环则不能完成全部课程，所以要返回一个空数组
   if (hasCycle(globalMarked, localMarked, i, graph, postOrder)) {
    return new int[0];
   }
  }

  int[] order = new int[numCourses];
  for (int i = numCourses - 1; i >= 0; --i) {
   order[i] = postOrder.pop();
  }
  return order;
 }

 private boolean hasCycle(boolean[] globalMarked, boolean[] localMarked, int curNode, List<Integer>[] graph,
   Stack<Integer> postOrder) {
  if (localMarked[curNode]) {
   return true;
  }

  // 保证节点不会重复进入栈中
  if (globalMarked[curNode]) {
   return false;
  }
  localMarked[curNode] = true;
  globalMarked[curNode] = true;
  for (int nextNode : graph[curNode]) {
   if (hasCycle(globalMarked, localMarked, nextNode, graph, postOrder)) {
    return true;
   }
  }

  // 回溯
  localMarked[curNode] = false;
  postOrder.push(curNode);
  return false;
 }
}
// @lc code=end
// 使用 DFS 来实现拓扑排序，使用一个栈存储后序遍历结果，这个栈的逆序结果就是拓扑排序结果。

// 证明：对于任何先序关系：v->w，后序遍历结果可以保证 w 先进入栈中，因此栈的逆序结果中 v 会在 w 之前。
