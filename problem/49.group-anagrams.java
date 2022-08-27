class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            List<String> list = new ArrayList<>();
            String normalStr = getNormalStr(str);
            if(map.containsKey(normalStr)){
                list = map.get(normalStr);
            }
            list.add(str);
            map.put(normalStr, list);
        }
        for(String str:map.keySet()){
            res.add(map.get(str));
        }
        return res;
    }
    
    private String getNormalStr(String str) {
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
}