class Solution {
    TreeMap<Integer, List<String>> map;
    String oriStr;
    Set<String> situations;
    public List<String> removeInvalidParentheses(String s) {
        map = new TreeMap<>();
        situations = new HashSet<>();
        oriStr = s;
        backTracking(s);
        return map.firstEntry().getValue();
    }

    private void backTracking(String s) {
        int cnt = oriStr.length()-s.length();
        if(situations.contains(s)){
            return;
        }
        if(!map.isEmpty()&&cnt>map.firstKey()){
            return;
        }
        if(isValid(s)){
            map.putIfAbsent(cnt, new ArrayList<>());
            if(!map.get(cnt).contains(s)){
                map.get(cnt).add(s);
            }
            return;
        }
        situations.add(s);
        for(int i=0; i<s.length(); ++i){
            String cur = s.substring(0,i) + s.substring(i+1, s.length());
            backTracking(cur);
        }
    }

    private boolean isValid(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }

        return cnt == 0;
    }

}