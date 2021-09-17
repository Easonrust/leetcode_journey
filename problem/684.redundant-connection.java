/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {
 public int[] findRedundantConnection(int[][] edges) {
  int N = edges.length;
  UF uf = new UF(N);
  for (int[] e : edges) {
   int u = e[0], v = e[1];
   if (uf.connect(u, v)) {
    return e;
   }
   uf.union(u, v);
  }
  return new int[] { -1, -1 };

 }

 private class UF {
  int[] id;

  UF(int N) {
   id = new int[N + 1];
   for (int i = 0; i < N + 1; ++i) {
    id[i] = i;
   }
  }

  int find(int i) {
   return id[i];
  }

  void union(int u, int v) {
   int uId = find(u);
   int vId = find(v);
   if (uId == vId) {
    return;
   }
   for (int i = 0; i < id.length; ++i) {
    if (id[i] == uId) {
     id[i] = vId;
    }
   }
  }

  boolean connect(int u, int v) {
   return find(u) == find(v);
  }
 }
}

// @lc code=end
// 使用并查集进行解题，十分简单详见https://zhuanlan.zhihu.com/p/93647900/
