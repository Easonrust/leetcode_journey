class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIdx = new int[26];
        for(int i=0; i<s.length(); ++i){
            lastIdx[s.charAt(i)-'a'] = i;
        }
        
        boolean[] visited = new boolean[26];
        Deque<Character> dq = new LinkedList<>();
        
        for(int i = 0; i<s.length(); ++i){
            char ch = s.charAt(i);
            if(visited[ch-'a']){
                continue;
            }
            
            while(!dq.isEmpty()&&lastIdx[dq.getLast()-'a']>i&&dq.getLast()>ch){
                char out = dq.removeLast();
                visited[out-'a'] = false;
            }
            
            dq.addLast(ch);
            visited[ch-'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()){
            sb.append(dq.removeFirst());
        }
        
        return sb.toString();
    }
}
