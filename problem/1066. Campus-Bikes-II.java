class Solution {
    boolean visited[];
    int res;

    public int assignBikes(int[][] workers, int[][] bikes) {
        visited = new boolean[bikes.length];
        res = Integer.MAX_VALUE;
        backTracking(workers, 0, bikes, 0);
        return res;
    }

    private int findDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    private void backTracking(int[][] workers, int idx, int[][] bikes, int sum) {
        if (idx == workers.length) {
            res = Math.min(res, sum);
            return;
        }

        // do not continue the search
        if (sum >= res) {
            return;
        }

        for (int i = 0; i < bikes.length; ++i) {
            if (!visited[i]) {
                int temp = findDistance(workers[idx], bikes[i]);
                visited[i] = true;
                backTracking(workers, idx + 1, bikes, temp + sum);
                visited[i] = false;
            }
        }

        return;
    }
}

// backtracking
