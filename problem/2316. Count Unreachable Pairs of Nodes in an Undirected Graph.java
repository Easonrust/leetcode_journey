class Solution {
    class UF {
        int[] parent;
        long[] size;
        UF(int n){
            parent = new int[n];
            size = new long[n];
            for(int i=0; i<n; ++i){
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int i){
            while(i!=parent[i]){
                i = parent[i];
            }
            return i;
        }

        void union(int i, int j){
            int a = find(i);
            int b = find(j);
            if(a==b){
                return;
            }
            if(size[a]>size[b]){
                parent[b] = a;
                size[a] += size[b];
            }else{
                parent[a] = b;
                size[b] += size[a];
            }
        }

        boolean connected(int i, int j){
            return find(i)==find(j);
        }
    }
    public long countPairs(int n, int[][] edges) {
        UF uf = new UF(n);
        long cnt = 0;
        for(int[] edge:edges){
            int i = edge[0];
            int j = edge[1];
            if(uf.connected(i, j)){
                continue;
            }
            uf.union(i,j);
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; ++i){
            set.add(uf.find(i));
        }
        for(int i:set){
            long sz = uf.size[i];
            cnt += (long)(sz*(sz-1));
        }
        return ((long)n*(long)(n-1)-cnt)/2;
    }
}