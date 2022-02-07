class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;
        int rowHits = 0;
        int[] colHits = new int[n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // 最开始或者遇到墙之后, 才去更新记录的可复用的rowHits
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowHits = 0;
                    for (int k = 0; k < n; ++k) {
                        if (grid[i][k] == 'W') {
                            break;
                        }

                        if (grid[i][k] == 'E') {
                            rowHits += 1;
                        }
                    }
                }

                // 最开始或者遇到墙之后, 才去更新记录的可复用的colHits
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colHits[j] = 0;
                    for (int k = i; k < m; ++k) {
                        if (grid[k][j] == 'W')
                            break;
                        else if (grid[k][j] == 'E')
                            colHits[j] += 1;
                    }
                }

                // 在可放置炸弹的空地处计算可炸死敌人的数量
                if (grid[i][j] == '0') {
                    res = Math.max(res, rowHits + colHits[j]);
                }
            }
        }
        return res;
    }
}

// dp, 注意rowHits只用一个变量记录即可，不需要用数组记录
