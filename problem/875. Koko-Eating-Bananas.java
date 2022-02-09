class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for (int pile : piles) {
            right = Math.max(pile, right);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (checkSpeed(mid, piles, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right + 1;
    }

    private boolean checkSpeed(int s, int[] piles, int h) {
        int c = 0;
        for (int pile : piles) {
            c += Math.ceil((double) pile / (double) s);
        }

        return c <= h;
    }
}

// 二分法，长度二分 类似 https://leetcode.com/problems/longest-repeating-substring/
