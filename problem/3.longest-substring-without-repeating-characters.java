class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            right++;
            window.put(c1, window.getOrDefault(c1, 0) + 1);

            while (window.get(c1) > 1) {
                char c2 = s.charAt(left);
                left++;
                window.put(c2, window.get(c2) - 1);
            }

            res = Math.max(res, right - left);
        }

        return res;
    }
}