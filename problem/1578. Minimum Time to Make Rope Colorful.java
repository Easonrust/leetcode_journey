class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int curMax = 0;
        int res = 0;
        for(int i=0; i<n; ++i){
            if(i>0&&colors.charAt(i)!=colors.charAt(i-1)){
                curMax = 0;
            }
            
            res += Math.min(curMax, neededTime[i]);
            curMax = Math.max(curMax, neededTime[i]);
        }
        return res;
    }
}

// 保证一串相同颜色留下的是neededTime最大的那个