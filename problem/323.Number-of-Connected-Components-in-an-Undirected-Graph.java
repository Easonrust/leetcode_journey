class Solution {
 public int countComponents(int n, int[][] edges) {
  UF uf = new UF(n);
  HashSet<Integer> set = new HashSet<>();
  for (int[] edge : edges) {
   if (!uf.connect(edge[0], edge[1])) {
    uf.union(edge[0], edge[1]);
   }
  }
  for (int i = 0; i < n; ++i) {
   set.add(uf.find(i));
  }
  return set.size();
 }

 private class UF {
  private int[] id;

  UF(int n) {
   id = new int[n];
   for (int i = 0; i < n; ++i) {
    id[i] = i;
   }
  }

  void union(int u, int v) {
   int uid = find(u);
   int vid = find(v);
   if (uid == vid) {
    return;
   }
   for (int i = 0; i < id.length; ++i) {
    if (id[i] == uid) {
     id[i] = vid;
    }
   }
  }

  int find(int p) {
   return id[p];
  }

  boolean connect(int u, int v) {
   return id[u] == id[v];
  }
 }
}

// Union and find