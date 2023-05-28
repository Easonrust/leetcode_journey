class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                Set<Integer> set1 = new HashSet<>();
                Set<Integer> set2 = new HashSet<>();
                int i1 = i-1;
                int j1 = j-1;
                while(i1>=0&&j1>=0){
                    set1.add(grid[i1][j1]);
                    i1--;
                    j1--;
                }
                int i2 = i+1;
                int j2 = j+1;
                while(i2<m&&j2<n){
                    set2.add(grid[i2][j2]);
                    i2++;
                    j2++;
                }
                res[i][j] = Math.abs(set1.size()-set2.size());
            }
        }
        return res;
    }
}