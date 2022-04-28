class Solution {
    class UF {
        int[] parent;
        int[] size;

        UF(int N) {
            parent = new int[N];
            size = new int[N];
            for (int i = 0; i < N; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            int x = i;
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }

        public void union(int i, int j) {
            int x = find(i);
            int y = find(j);
            if (x == y) {
                return;
            }
            if (size[x] < size[y]) {
                parent[x] = y;
                size[y] += size[x];
            } else {
                parent[y] = x;
                size[x] += size[y];
            }
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UF uf = new UF(s.length());
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            int root = uf.find(i);
            List<Integer> group = new ArrayList<>();
            if (map.containsKey(root)) {
                group = map.get(root);
            }
            group.add(i);
            map.put(root, group);
        }
        char[] sArr = s.toCharArray();
        for (List<Integer> group : map.values()) {
            List<Character> characters = new ArrayList<>();
            for (int idx : group) {
                characters.add(s.charAt(idx));
            }
            Collections.sort(characters);
            Collections.sort(group);
            for (int i = 0; i < group.size(); ++i) {
                sArr[group.get(i)] = characters.get(i);
            }
        }
        return new String(sArr);
    }

}
