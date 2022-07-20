class Solution {
    class Node {
        String word;
        int index;
        public Node(String word, int index){
            this.word = word;
            this.index = index;
        }
    }
    public int numMatchingSubseq(String s, String[] words) {
        int res = 0;
        List<Node>[] heads = new ArrayList[26];
        for(int i=0; i<26; ++i){
            heads[i] = new ArrayList<>();
        }
        for(String word:words){
            heads[word.charAt(0)-'a'].add(new Node(word, 0));
        }
        
        for(int i = 0; i<s.length(); ++i){
            char c = s.charAt(i);
            List<Node> bucket = heads[c-'a'];
            heads[c-'a'] = new ArrayList<>();
            for(Node node:bucket){
                node.index++;
                if(node.index==node.word.length()){
                    res++;
                }else{
                    heads[node.word.charAt(node.index)-'a'].add(node);
                }
            }
        }
        
        return res;
    }
}