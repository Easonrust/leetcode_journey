/*
 * @lc app=leetcode id=368 lang=java
 *
 * [368] Largest Divisible Subset
 */

// @lc code=start
class Solution {
 public List<Integer> largestDivisibleSubset(int[] nums) {
     int n=nums.length;
     List<Integer> res=new ArrayList<>();
     if(n==1){
         res.add(nums[0]);
         return res;
     }

     Arrays.sort(nums);

     List<Integer>[] dp=new ArrayList[n];
     

     
     for(int i=0;i<n;++i){
         int max=0;
         int maxIdx=-1;
         dp[i]=new ArrayList<>();
         for(int j=0;j<i;++j){
             if(nums[i]%nums[j]==0){
                 if(max<dp[j].size()){
                     max=dp[j].size();
                     dp[i]=new ArrayList<>(dp[j]);
                 }
             }
         }
         
         dp[i].add(nums[i]);
     }
     
     int maxSize=0;
     
     for(int i=0;i<n;++i){
         if(maxSize<dp[i].size()){
             maxSize=dp[i].size();
             res=dp[i];
         }
     }
     
     return res;
 }
}

// dp
// @lc code=end

