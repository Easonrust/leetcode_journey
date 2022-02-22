class Solution {
    private int[] cities;

    public int minimumCost(int n, int[][] connections) {
        int res = 0;
        int cnt = 1;
        Arrays.sort(connections, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        cities = new int[n + 1];
        Arrays.fill(cities, -1);

        for (int i = 0; i < connections.length; ++i) {
            int x = find(connections[i][0]);
            int y = find(connections[i][1]);
            if (find(x) == find(y)) {
                continue;
            }
            cities[x] = y;
            res += connections[i][2];
            cnt += 1;
        }

        return cnt == n ? res : -1;
    }

    private int find(int id) {
        if (cities[id] == -1) {
            return id;
        }

        return find(cities[id]);
    }
}

// Kruskal MST 算法，使用union-find
