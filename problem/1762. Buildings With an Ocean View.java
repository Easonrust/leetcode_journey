class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int highest = 0;
        for(int i=heights.length-1; i>=0; --i){
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
