
class Solution {
    class UF{
        int[] parent;
        int[] size;
        UF(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0; i<n; ++i){
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int i){
            while(parent[i]!=i){
                i = parent[i];
            }
            return i;
        }

        void union(int i, int j){
            int x = find(i);
            int y = find(j);
            if(x==y){
                return;
            }
            if(size[x]>size[y]){
                size[x] += size[y];
                size[y] = 0;
                parent[y] = x;
            }else{
                size[y] += size[x];
                size[x] = 0;
                parent[x] = y;
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UF uf = new UF(n);
        for(int i=0; i<n; ++i){
            int[] stone1 = stones[i];
            for(int j=0; j<i; ++j){
                int[] stone2 = stones[j];
                if(stone1[0]==stone2[0]||stone1[1]==stone2[1]){
                    uf.union(i, j);
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<n; ++i){
            if(uf.size[i]>0){
                cnt++;
            }
        }
        return n - cnt;
    }
}