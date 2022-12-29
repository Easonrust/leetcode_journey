class Solution {
    boolean[][] visited;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        visited = new boolean[m][n];
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int last, int color) {
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0, 1}};
        int m = image.length;
        int n = image[0].length;
        if(sr<0||sr>=m||sc<0||sc>=n){
            return;
        }
        int cur = image[sr][sc];
        if(cur!=last||visited[sr][sc]==true){
            return;
        }
        image[sr][sc] = color;
        visited[sr][sc] = true;
        for(int[] dir:dirs){
            dfs(image, sr+dir[0], sc+dir[1], cur, color);
        }
    }
}
