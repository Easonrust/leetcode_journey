class Solution {
    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        int left = 1, right = n;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (checkString(mid, n, s)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left - 1;
    }

    private boolean checkString(int l, int n, String s) {
        HashSet<Integer> seen = new HashSet();
        for (int i = 0; i < n - l + 1; ++i) {
            int h = s.substring(i, i + l).hashCode();
            if (seen.contains(h)) {
                return true;
            }
            seen.add(h);
        }
        return false;
    }
}

// 二分查找，如果存在长度为k的字符串，那么可能存在k+1的；不存在长度为k的，可能存在k-1的
