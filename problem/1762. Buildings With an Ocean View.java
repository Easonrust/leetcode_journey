class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        
        int highest = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=n-1; i>=0; --i){
            if(heights[i]>highest){
                list.add(i);
                highest = heights[i];
            }
        }
        
        Collections.sort(list);
        int[] res = new int[list.size()];
        for(int i=0; i<res.length; ++i){
            res[i] = list.get(i);
        }
        
        return res;
    }
}