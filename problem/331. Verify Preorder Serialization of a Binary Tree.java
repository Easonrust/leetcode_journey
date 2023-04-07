class Solution {
    public boolean isValidSerialization(String preorder) {
        int slots = 1;
        int idx = 0;
        while(idx<preorder.length()){
            char ch = preorder.charAt(idx);
            if(slots==0){
                return false;
            }
            if(ch=='#'){
                slots--;
                idx++;
            }else if(ch==','){
                idx++;
            }else if(Character.isDigit(ch)){
                slots = slots - 1 + 2;
                while(idx<preorder.length()&&preorder.charAt(idx)!=','){
                    idx++;
                }
            }
        }
        return slots==0;
    }
}