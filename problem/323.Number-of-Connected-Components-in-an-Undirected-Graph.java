class Solution {
    class UF{
        int[] size;
        int[] parent;
        UF(int n){
            size = new int[n];
            parent = new int[n];
            for(int i=0; i<n; ++i){
                size[i] = 1;
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            while(parent[x]!=x){
                x = parent[x];
            }
            return x;
        }
        
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX==rootY){
                return;
            }
            if(size[rootX]>size[rootY]){
                size[rootX] += size[rootY];
                parent[rootY] = rootX;
            }else{
                size[rootY] += size[rootX];
                parent[rootX] = rootY;
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for(int[] edge:edges){
            uf.union(edge[0],edge[1]);
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; ++i){
            set.add(uf.find(i));
        }
        return set.size();
    }
}