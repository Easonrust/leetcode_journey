class Solution {
    int[] square;
    boolean res = false;
    int l = 0;
    public boolean makesquare(int[] matchsticks) {
        square = new int[4];
        
        int sum = 0;
        for(int matchstick:matchsticks){
            sum+=matchstick;
        }
        
        if(sum%4!=0){
            return false;
        }
        
        l = sum/4;
        
        for(int i=0; i<matchsticks.length; ++i){
            matchsticks[i] = - matchsticks[i];
        }
        Arrays.sort(matchsticks);
        for(int i=0; i<matchsticks.length; ++i){
            matchsticks[i] = - matchsticks[i];
        }
        
        backTracking(matchsticks, 0);
        return res;
    }
    
    private void backTracking(int[] matchsticks, int i) {
        if(i==matchsticks.length){
            if(checkValid()){
                res = true;
            }
            return;
        }
        
        if(res){
            return;
        }
        
        int matchstick = matchsticks[i];
        
        for(int j=0; j<4; ++j){
            if(square[j]>l-matchstick){
                continue;
            }
            square[j] += matchstick;
            backTracking(matchsticks, i+1);
            square[j] -= matchstick;
        }
        
        return;
    }
    
    private boolean checkValid(){
        for(int s:square){
            if(s!=l){
                return false;
            }
        }
        return true;
    }
}
