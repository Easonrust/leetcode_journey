class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int rowNum = 1;
        while(rowNum<=numRows){
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = new ArrayList<>();
            if(rowNum>1){
                preRow = res.get(rowNum-2);
            }
            for(int i=0; i<rowNum; ++i){
                if(i==0||i==(rowNum-1)){
                    row.add(1);
                }else{
                    row.add(preRow.get(i-1)+preRow.get(i));
                }
            }
            res.add(row);
            rowNum++;
        }
        
        return res;
    }
}