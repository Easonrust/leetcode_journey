class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0;
        int cum = 0;
        while(mainTank>0){
            mainTank--;
            cum++;
            res+=10;
            if(cum==5&&additionalTank>0){
                additionalTank--;
                mainTank++;
                cum = 0;
            }
        }
        return res;
    }
}