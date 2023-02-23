class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Integer[] projects = new Integer[profits.length];
        for(int i=0; i<projects.length; ++i){
            projects[i] = i;
        }
        Arrays.sort(projects,(o1,o2)->(capital[o1]-capital[o2]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->(profits[o2]-profits[o1]));
        int idx = 0;
        int num = 0;
        while(num<k){
            while(idx<projects.length&&capital[projects[idx]]<=w){
                pq.offer(projects[idx]);
                idx++;
            }
            if(pq.isEmpty()){
                break;
            }
            w += profits[pq.poll()];
            num++;
        }
        return w;
    }

}