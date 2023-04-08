class Solution {
    public String rankTeams(String[] votes) {
        int rounds = votes[0].length();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer>[] mapArr = new HashMap[rounds];

        for(int i=0; i<rounds; ++i){
            mapArr[i] = new HashMap<>();
            for(Character ch:votes[0].toCharArray()){
                mapArr[i].put(ch, 0);
            }
            for(String vote:votes){
                mapArr[i].put(vote.charAt(i), mapArr[i].get(vote.charAt(i))+1);
            }
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Character a, Character b){
                for(Map<Character, Integer> map:mapArr){
                    if(map.get(a)==map.get(b)){
                        continue;
                    }
                    return map.get(b) - map.get(a);
                }
                return a-b;
            }
        });
        for(Character ch:votes[0].toCharArray()){
            pq.offer(ch);
        }
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        return sb.toString();
    }
}