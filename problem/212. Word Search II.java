class Node {
    Node[] next;
    boolean isEnd;
    public static final int R = 26;
    Node(){
        next = new Node[26];
        isEnd = false;
    }
}

class Trie {
    Node root;
    Trie(){
        root = new Node();
    }

    void insert(String word){
        Node node = root;
        for(char ch:word.toCharArray()){
            if(node.next[ch-'a']==null){
                node.next[ch-'a'] = new Node();
            }
            node = node.next[ch-'a'];
        }
        node.isEnd = true;
    }

    boolean search(String word){
        Node node = root;
        for(char ch:word.toCharArray()){
            if(node.next[ch-'a']==null){
                return false;
            }
            node = node.next[ch-'a'];
        }
        return node.isEnd;
    }

    boolean prefix(String word){
        Node node = root;
        for(char ch:word.toCharArray()){
            if(node.next[ch-'a']==null){
                return false;
            }
            node = node.next[ch-'a'];
        }
        return true;
    }
}

class Solution {
    boolean[][] visited;
    Set<String> track = new HashSet<>();
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word:words){
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++){
            if(track.size()>=words.length){
                break;
            }
            for(int j=0; j<n; j++){
                sb.append(board[i][j]);
                if(trie.prefix(sb.toString())){
                    visited[i][j] = true;
                    dfs(board, trie, sb, i, j);
                    visited[i][j] = false;
                }
                sb.deleteCharAt(sb.length()-1);
            }
        }
        List<String> res = new ArrayList<>();
        for(String str:track){
            res.add(str);
        }
        return res;
    }

    private void dfs(char[][] board, Trie trie, StringBuilder sb, int i, int j) {
        String cur = sb.toString();
        if(trie.search(cur)){
            track.add(cur);
        }

        int m = board.length;
        int n = board[0].length;

        for(int[] dir:dirs){
            int ni = i+dir[0];
            int nj = j+dir[1];
            if(ni<0||nj<0||ni>=m||nj>=n){
                continue;
            }
            if(visited[ni][nj]){
                continue;
            }
            sb.append(board[ni][nj]);
            if(trie.prefix(sb.toString())){
                visited[ni][nj] = true;
                dfs(board, trie, sb, ni, nj);
                visited[ni][nj] = false;
            }
            sb.deleteCharAt(sb.length()-1);
        }
    }
}