class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        int res = 0;
        int right = 0;
        int left = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(right), 1);

        while (left <= n) {
            if (map.keySet().size() <= 2) {
                res = Math.max(res, left - right);
                left++;
                if (left <= n) {
                    map.put(s.charAt(left - 1), map.getOrDefault(s.charAt(left - 1), 0) + 1);
                }
            } else {
                right++;
                if (right < left) {
                    map.put(s.charAt(right - 1), map.get(s.charAt(right - 1)) - 1);
                    if (map.get(s.charAt(right - 1)) == 0) {
                        map.remove(s.charAt(right - 1));
                    }
                }
            }
        }

        return res;
    }
}

// sliding window
