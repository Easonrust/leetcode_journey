class Solution {
    class UF {
        int count;
        int[] parent;

        UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                x = parent[x];
            }
            return x;
        }

        public boolean connect(int i, int j) {
            return find(i) == find(j);
        }

        public void union(int i, int j) {
            int x = parent[i];
            int y = parent[j];
            if (x == y) {
                return;
            }
            parent[x] = y;
            count--;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            if (uf.connect(i, j)) {
                return false;
            }
            uf.union(i, j);
        }
        return uf.count == 1;
    }
}