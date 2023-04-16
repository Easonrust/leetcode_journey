class Solution {
    public int[] findBuildings(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int n = heights.length;
        Deque<Integer> res = new LinkedList<>();
        for(int i=n-1; i>=0; --i){
            while(!stack.isEmpty()&&stack.peek()<heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res.push(i);
            }
            stack.push(heights[i]);
        }
        int[] resArr = new int[res.size()];
        for(int i=0; i<resArr.length; ++i){
            resArr[i] = res.pop();
        }
        return resArr;
    }
}