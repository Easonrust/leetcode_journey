/*
 * @lc app=leetcode id=1492 lang=java
 *
 * [1492] The kth Factor of n
 */

// @lc code=start
class Solution {
 public int kthFactor(int n, int k) {
     List<Integer> factors=new ArrayList();
     int sqrtN=(int) Math.sqrt(n);
     for(int x=1;x<sqrtN+1;++x){
         if(n%x==0){
             k--;
             factors.add(x);
             if(k==0){
                 return x;
             }
         }
     }
     
     // skip the duplicate
     if(sqrtN*sqrtN==n){
         k++;
     }
     
     int m=factors.size();
     
     if(m<k){
         return -1;
     }
     
     return n/factors.get(m-k);
 }
}

// 利用了factor对称的性质
// @lc code=end

