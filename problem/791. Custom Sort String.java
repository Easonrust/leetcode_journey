class Solution {
    public String customSortString(String order, String s) {
        Character[] chArr = new Character[s.length()];
        for(int i=0; i<chArr.length; ++i){
            chArr[i] = s.charAt(i);
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<order.length(); ++i){
            map.put(order.charAt(i), i);
        }
        for(int j=0; j<s.length(); ++j){
            if(map.containsKey(s.charAt(j))){
                continue;
            }
            map.put(s.charAt(j), -1);
        }
        Arrays.sort(chArr, new Comparator<>(){
            @Override
            public int compare(Character a, Character b){
                return map.get(a) - map.get(b);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Character ch:chArr){
            sb.append(ch);
        }
        return sb.toString();
    }
}