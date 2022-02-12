class Solution {
    public String[][] pairs = { { "0", "0" }, { "1", "1" }, { "8", "8" }, { "6", "9" }, { "9", "6" } };

    public List<String> findStrobogrammatic(int n) {
        return getStrobogrammatic(n, n);
    }

    private List<String> getStrobogrammatic(int n, int length) {
        if (n == 0) {
            return new ArrayList<>(List.of(""));
        }

        if (n == 1) {
            return new ArrayList<>(List.of("1", "8", "0"));
        }

        List<String> midStrobogrammatics = getStrobogrammatic(n - 2, length);
        List<String> res = new ArrayList<>();

        for (String midStr : midStrobogrammatics) {
            for (String[] pair : pairs) {
                if (pair[0] != "0" || n != length) {
                    res.add(pair[0] + midStr + pair[1]);
                }
            }
        }

        return res;
    }
}

// 先把基本的几个case列出来讨论，然后recursion
