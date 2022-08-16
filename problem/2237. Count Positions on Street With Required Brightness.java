class Solution {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int[] diff = new int[n];
        int[] bri = new int[n];
        for(int[] light:lights){
            int pos = light[0];
            int range = light[1];
            int start = Math.max(0, pos-range);
            int end = Math.min(n-1, pos+range);
            diff[start] += 1;
            if(end+1<n){
                diff[end+1] -= 1;
            }
        }
        
        bri[0] = diff[0];
        
        for(int i=1; i<n; ++i){
            bri[i] = bri[i-1] + diff[i];
        }
        
        int cnt = 0;
        for(int i=0; i<n; ++i){
            if(bri[i]>=requirement[i]){
                cnt++;
            }
        }
        
        return cnt;
    }
}