class Trie {
    class TreeNode {
        public static final int R = 26;
        public TreeNode[] next;
        public boolean isEnd;

        TreeNode() {
            next = new TreeNode[R];
        }
    }

    TreeNode root;

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TreeNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                return false;
            }
            node = node.next[c - 'a'];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                return false;
            }
            node = node.next[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */