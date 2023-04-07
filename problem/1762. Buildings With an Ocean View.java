class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int highest = 0;
        int n = heights.length;
        for(int i=n-1; i>=0; i--){
            if(highest<heights[i]){
                list.add(i);
                highest = heights[i];
            }
        }

        Collections.reverse(list);
        int[] res = new int[list.size()];
        for(int i=0; i<res.length; ++i){
            res[i] = list.get(i);
        }
        return res;
    }
}