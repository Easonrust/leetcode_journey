class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        int left = 1;
        for(int i=1; i<n; ++i){
            left *= nums[i-1];
            answer[i] *= left;
        }

        int right = 1;
        for(int i=n-2; i>=0; --i){
            right *= nums[i+1];
            answer[i] *= right;
        }
        return answer;
    }
}