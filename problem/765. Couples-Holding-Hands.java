class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        UF uf = new UF(n / 2);
        for (int i = 0; i < n; i += 2) {
            int couple_id1 = row[i] / 2;
            int couple_id2 = row[i + 1] / 2;
            uf.union(couple_id1, couple_id2);
        }
        return n / 2 - uf.count();
    }
}

class UF {
    int count;
    int[] size;
    int[] parent;

    public UF(int n) {
        count = n;
        size = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
        count--;
    }

    public int count() {
        return this.count;
    }
}
