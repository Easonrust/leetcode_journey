class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        Map<String, String> map = new HashMap<>();
        for (List<String> similarPair : similarPairs) {
            for (String string : similarPair) {
                if (!map.containsKey(string)) {
                    map.put(string, "");
                }
            }
        }

        for (int i = 0; i < sentence1.length; ++i) {
            String string = sentence1[i];
            if (!map.containsKey(string)) {
                map.put(string, "");
            }
        }

        for (int i = 0; i < sentence2.length; ++i) {
            String string = sentence2[i];
            if (!map.containsKey(string)) {
                map.put(string, "");
            }
        }
        for (List<String> similarPair : similarPairs) {
            String x = find(map, similarPair.get(0));
            String y = find(map, similarPair.get(1));
            if (x.equals(y)) {
                continue;
            }

            // union
            map.put(x, y);
        }

        for (int i = 0; i < sentence1.length; ++i) {
            String x = find(map, sentence1[i]);
            String y = find(map, sentence2[i]);
            if (!x.equals(y)) {
                return false;
            }
        }
        return true;
    }

    private String find(Map<String, String> map, String string) {
        if (map.get(string).equals("")) {
            return string;
        }
        return find(map, map.get(string));
    }
}

// Union-find
