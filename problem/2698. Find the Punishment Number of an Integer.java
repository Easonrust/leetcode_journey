class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for(int i=1; i<=n; ++i){
            int square = i*i;
            String str = String.valueOf(square);
            if(isPunishmentNumber(str, i)){
                res += square;
                // if(i!=1){
                //     return i;
                // }
            }
        }
        return res;
    }
    
    private boolean isPunishmentNumber(String str, int sum) {
        if(sum<0){
            return false;
        }
        if(str.length()==0&&sum>0){
            return false;
        }
        if(str.length()==0&&sum==0){
            return true;
        }
        for(int pos=1; pos<=str.length(); ++pos){
            if(isPunishmentNumber(str.substring(pos), sum - Integer.parseInt(str.substring(0,pos)))){
                return true;
            }
        }
        return false;
    }
}