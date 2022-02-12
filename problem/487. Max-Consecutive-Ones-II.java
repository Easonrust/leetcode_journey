class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int zeroNum = 0;
        int res = 0;
        while (right < nums.length) {
            if (zeroNum > 1) {
                if (nums[left] == 0) {
                    zeroNum--;
                }
                left++;
            } else {
                if (nums[right] == 0) {
                    zeroNum++;
                }
                if (zeroNum <= 1) {
                    res = Math.max(res, right - left + 1);
                }
                right++;
            }
        }

        return res;
    }
}

// sliding window
