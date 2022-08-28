class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                if(map.containsKey(i-j)){
                    pq = map.get(i-j);
                }
                pq.offer(mat[i][j]);
                map.put(i-j, pq);
            }
        }
        
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                mat[i][j] = map.get(i-j).poll();
            }
        }
        
        return mat;
    }
}

// 在同一对角线上的元素 i-j 值相同
