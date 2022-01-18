class Solution {
 public boolean validTree(int n, int[][] edges) {
  int[] nodes = new int[n];
  Arrays.fill(nodes, -1);

  for (int i = 0; i < edges; ++i) {
   int x = find(nodes, edges[i][0]);
   int y = find(nodes, edges[i][1]);

   // 如果二者的联通分量编号相同，说明已经被连过了，即存在环
   if (x == y) {
    return false;
   }

   // union
   nodes[x] = y;
  }
 }

 private int find(int[] nodes, int i) {
  if (nodes[i] == -1) {
   return i;
  }

  return find(nodes, nodes[i]);
 }
}

// 使用union-find