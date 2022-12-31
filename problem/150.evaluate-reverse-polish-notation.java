class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for(String token:tokens) {
            if(!token.equals("+")&&!token.equals("-")&&!token.equals("*")&&!token.equals("/")){
                stack.push(Integer.parseInt(token));
                continue;
            }
            int num2 = stack.pop();
            int num1 = stack.pop();
            int res = 0;
            if(token.equals("+")){
                res = num1 + num2;
            }else if (token.equals("-")){
                res = num1 - num2;
            }else if (token.equals("*")){
                res = num1 * num2;
            }else{
                res = num1 / num2;
            }
            stack.push(res);
        }
        return stack.pop();
    }
}