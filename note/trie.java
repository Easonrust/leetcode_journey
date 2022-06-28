class Trie {
    class TrieNode {
        public static final int R = 26;
        TrieNode[] next;
        boolean isEnd;

        TrieNode() {
            next = new TrieNode[R];
        }
    }

    TrieNode root;

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null)
                node.next[c - 'a'] = new TrieNode();
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null)
                return false;
            node = node.next[c - 'a'];
        }
        return node.isEnd == true;
    }
}

// 前缀树