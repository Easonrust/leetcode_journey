class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();
        
        for(String str:strs){
            String normalStr = getNormalStr(str);
            List<String> group = new ArrayList<>();
            if(groups.containsKey(normalStr)){
                group = groups.get(normalStr);
            }
            group.add(str);
            groups.put(normalStr, group);
        }
        
        for(String key:groups.keySet()){
            res.add(groups.get(key));
        }
        
        return res;
    }
    
    private String getNormalStr(String str) {
        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
        return new String(strArr);
    }
}