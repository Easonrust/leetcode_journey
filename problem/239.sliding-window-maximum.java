class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        for(int i=0; i<k; ++i){
            while(!dq.isEmpty()&&dq.getLast()<nums[i]){
                dq.removeLast();
            }
            dq.addLast(nums[i]);
        }

        res[0] = dq.getFirst();

        for(int i=k; i<n; ++i){

            while(!dq.isEmpty()&&dq.getLast()<nums[i]){
                dq.removeLast();
            }
            dq.addLast(nums[i]);

            if(!dq.isEmpty()){
                if(nums[i-k]==dq.getFirst()){
                    dq.removeFirst();
                }
            }
            res[i-k+1] = dq.getFirst();
        }
        return res;

    }
}