class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0]!=o2[0]){
                    return o2[0] - o1[0];
                }
                return o1[1] - o2[1];
            }
        });
            
        int res = 0;
        int maxDefense = properties[0][1];
        for(int i=1; i<properties.length; ++i){
            if(properties[i][1]<maxDefense){
                res++;
            }else{
                maxDefense = properties[i][1];
            }
        }
        
        return res;
    }
}