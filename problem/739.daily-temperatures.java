class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for(int i=0; i<n; ++i){
            while(!stack.isEmpty()&&temperatures[stack.peek()]<temperatures[i]){
                int pre_idx = stack.pop();
                res[pre_idx] = i - pre_idx ;
            }
            stack.push(i);
        }
        return res;
    }
}