class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        
        int[] cnts = new int[26];
        int res = 0;
        int maxCnt = 0;
        
        while(right<s.length()){
            char in = s.charAt(right);
            right++;
            cnts[in-'A']++;
            maxCnt = Math.max(maxCnt, cnts[in-'A']);
            
            while(right-left-maxCnt>k){
                char out = s.charAt(left);
                left++;
                cnts[out-'A']--;
            }
            
            res = Math.max(res, right-left);
        }
        
        return res;
    }
}
