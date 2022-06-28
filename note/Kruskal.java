class Solution {
    public int minimumCost(int n, int[][] connections) {
        UF uf = new UF(n+1);
        Arrays.sort(connections, (o1,o2)->(o1[2]-o2[2]));
        int res = 0;
        for(int[] connection:connections){
            int x = connection[0];
            int y = connection[1];
            int cost = connection[2];
            if(uf.connected(x,y)){
                continue;
            }
            uf.union(x,y);
            res += cost;
        }
        if(uf.count()!=2){
            return -1;
        }
        return res;
    }
}

class UF {
    int count;
    int[] size;
    int[] parent;
    public UF(int n){
        count = n;
        size = new int[n];
        parent = new int[n];
        for(int i=0;i<n;++i){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int find(int x){
        while(parent[x]!=x){
            parent[x] = parent[parent[x]];
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
        if(size[rootX]<size[rootY]){
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }else{
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
        count--;
    }
    
    public boolean connected(int x, int y){
        return find(x)==find(y);
    }
    
    public int count(){
        return this.count;
    }
}