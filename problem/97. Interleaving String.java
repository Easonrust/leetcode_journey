class Solution {
    int[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m1 = s1.length();
        int m2 = s2.length();
        int m3 = s3.length();
        
        if((m1+m2)!=m3){
            return false;
        }
        
        memo = new int[m1+1][m2+1];
        for(int[] me:memo){
            Arrays.fill(me, -1);
        }
        
        return dp(s1, 0, s2, 0, s3);
    }
    
    private boolean dp(String s1, int i, String s2, int j, String s3) {
        int m1 = s1.length();
        int m2 = s2.length();
        int m3 = s3.length();
        
        if((i+j)==m3){
            return true;
        }
        
        if(memo[i][j]!=-1){
            return (memo[i][j] == 1);
        }
        
        char c3 = s3.charAt(i+j);
        
        boolean res = false;
        
        if(i<m1){
            char c1 = s1.charAt(i);
            if(c1==c3){
                res = res || dp(s1, i+1, s2, j, s3);
            }
        }
        
        if(j<m2){
            char c2 = s2.charAt(j);
            if(c2==c3){
                res = res || dp(s1, i, s2, j+1, s3);
            }
        }
        
        memo[i][j] =  res ? 1 : 0;
        
        return res;
    }
}