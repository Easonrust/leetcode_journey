class Solution {
    public int countBeautifulPairs(int[] nums) {
        int res = 0;
        for(int j=1; j<nums.length; ++j){
            for(int i=0; i<j; ++i){
                String str1 = String.valueOf(nums[i]);
                int num1 = str1.charAt(0) - '0';
                String str2 = String.valueOf(nums[j]);
                int num2 = str2.charAt(str2.length()-1) - '0';
                if(gcd(num1, num2)==1){
                    res++;
                }
            }
        }
        return res;
    }
    
    private int gcd(int a, int b) {
        int remainder = a%b;
        while(remainder!=0){
            a=b;
            b=remainder;
            remainder = a%b;
        }
        return b;
    }
}