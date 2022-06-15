class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            right++;
            window.put(c1, window.getOrDefault(c1, 0) + 1);

            int valid = 0;
            for (char c : needs.keySet()) {
                if (window.getOrDefault(c, 0) >= needs.get(c)) {
                    valid++;
                }
            }

            while (valid == needs.keySet().size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char c2 = s.charAt(left);
                left++;
                window.put(c2, window.get(c2) - 1);
                for (char c : needs.keySet()) {
                    if (window.get(c) < needs.get(c)) {
                        valid--;
                    }
                }
            }
        }
        if (len == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + len);
    }
}