class Solution {
    class UF {
        int[] parent;
        public UF(){
            parent = new int[26];
            for(int i=0; i<26; ++i){
                parent[i] = i;
            }
        }
        
        public int find(int i) {
            while(parent[i]!=i){
                i = parent[i];
            }
            return i;
        }
        
        public void union(int i, int j) {
            int a = find(i);
            int b = find(j);
            if(a==b){
                return;
            }
            parent[a] = b;
        }
        
        public boolean connected(int i, int j) {
            return find(i) == find(j);
        }
    }
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF();
        for(String equation:equations) {
            char sym = equation.charAt(1);
            char a = equation.charAt(0);
            char b = equation.charAt(3);
            if(sym=='='){
                uf.union(a-'a', b-'a');
            }
        }
        
        for(String equation:equations) {
            char sym = equation.charAt(1);
            char a = equation.charAt(0);
            char b = equation.charAt(3);
            if(sym=='!'){
               if(uf.connected(a-'a', b-'a')){
                   return false;
               }
            }
        }
        
        return true;
    }
}