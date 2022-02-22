class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> inorder = new Stack<>();

        for (int v : preorder) {
            if (!inorder.isEmpty() && v < inorder.peek())
                return false;
            while (!stack.isEmpty() && v > stack.peek()) {
                inorder.push(stack.pop());
            }
            stack.push(v);
        }
        return true;
    }
}
