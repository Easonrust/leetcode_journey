class Trie {
    class TreeNode {
        TreeNode[] next;
        int end;
        int start;

        TreeNode() {
            next = new TreeNode[26];
            end = 0;
            start = 0;
        }
    }

    TreeNode root;

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TreeNode();
            }
            node = node.next[c - 'a'];
            node.start += 1;
        }

        node.end += 1;
    }

    public int countWordsEqualTo(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (node.next[c - 'a'] == null) {
                return 0;
            }
            node = node.next[c - 'a'];
        }
        return node.end;
    }

    public int countWordsStartingWith(String prefix) {
        TreeNode node = root;
        for (int i = 0; i < prefix.length(); ++i) {
            char c = prefix.charAt(i);
            if (node.next[c - 'a'] == null) {
                return 0;
            }
            node = node.next[c - 'a'];
        }
        return node.start;
    }

    public void erase(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (node.next[c - 'a'] == null) {
                return;
            }
            node = node.next[c - 'a'];
            node.start -= 1;
        }
        node.end -= 1;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
