class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0;
        int cur = 0;
        for(int gai:gain){
            cur += gai;
            res = Math.max(res, cur);
        }
        return res;
    }
}