class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for(int i=0; i<senate.length(); ++i){
            char ch = senate.charAt(i);
            if(ch=='R'){
                radiant.offer(i);
            }else{
                dire.offer(i);
            }
        }

        while(!radiant.isEmpty()&&!dire.isEmpty()){
            int ridx = radiant.poll();
            int didx = dire.poll();
            if(ridx<didx){
                radiant.offer(ridx+n);
            }else{
                dire.offer(didx+n);
            }
        }

        if(radiant.isEmpty()){
            return "Dire";
        }

        return "Radiant";
    }
}