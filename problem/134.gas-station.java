/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int total=0;
        int sum=0;
        for(int i=0;i<gas.length;++i){
         total+=gas[i]-cost[i];
         if(sum<0){
          sum=gas[i]-cost[i];
          start=i;
         }else{
          sum+=gas[i]-cost[i];
         }
        }
        if(total<0){
         return -1;
        }
        return start;
    }
}
// @lc code=end
// https://blog.csdn.net/qq_41231926/article/details/85521304

