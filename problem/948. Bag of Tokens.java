class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int res = 0;
        int l = 0;
        int r = tokens.length-1;
        while(l<=r){
            if(power>=tokens[l]){
                power-=tokens[l];
                res += 1;
                l++;
            }else if(l!=r&&res>0){
                res -= 1;
                power+=tokens[r];
                r--;
            }else{
                l++;
            }
        }
        return res;
    }
}

// greedy