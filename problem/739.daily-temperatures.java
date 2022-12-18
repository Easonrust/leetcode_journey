class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty()&&temperatures[stack.getLast()]<=temperatures[i]){
                stack.removeLast();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.getLast() - i);
            stack.addLast(i);
        }
        return res;
    }
}