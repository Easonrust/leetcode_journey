class Trie {
    class TreeNode {
        TreeNode[] next;
        boolean isEnd;

        TreeNode() {
            isEnd = false;
            next = new TreeNode[26];
        }
    }

    TreeNode root = new TreeNode();
    List<String> resultBuffer;

    public void insert(String s) {
        TreeNode node = root;
        for (char c : s.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TreeNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String s) {
        TreeNode node = root;
        for (char c : s.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                return false;
            }
            node = node.next[c - 'a'];
        }
        return node.isEnd == true;
    }

    public boolean getWordsStartWith(String prefix) {
        resultBuffer = new ArrayList<>();
        TreeNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                return false;
            }
            node = node.next[c - 'a'];
        }
        StringBuilder sb = new StringBuilder(prefix);

        dfs(node, sb);
        return true;
    }

    public void dfs(TreeNode node, StringBuilder sb) {
        if (resultBuffer.size() == 3) {
            return;
        }
        if (node.isEnd) {
            resultBuffer.add(sb.toString());
        }
        for (int i = 0; i < node.next.length; ++i) {
            if (node.next[i] != null) {
                sb.append((char) ('a' + i));
                dfs(node.next[i], sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }

        List<List<String>> res = new ArrayList<>();
        int i;
        for (i = 1; i <= searchWord.length(); ++i) {
            if (trie.getWordsStartWith(searchWord.substring(0, i))) {
                res.add(trie.resultBuffer);
            } else {
                break;
            }
        }
        for (; i <= searchWord.length(); ++i) {
            res.add(new ArrayList<>());
        }
        return res;
    }
}