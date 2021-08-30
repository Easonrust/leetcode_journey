import java.util.Stack;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (47.61%)
 * Likes:    5803
 * Dislikes: 516
 * Total Accepted:    786.3K
 * Total Submissions: 1.6M
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n' +
  '[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * Implement the MinStack class:
 * 
 * 
 * MinStack() initializes the stack object.
 * void push(val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * 
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -2^31 <= val <= 2^31 - 1
 * Methods pop, top and getMin operations will always be called on non-empty
 * stacks.
 * At most 3 * 10^4 calls will be made to push, pop, top, and getMin.
 * 
 * 
 */

// @lc code=start
class MinStack {

 private Stack<Integer> dataStack = new Stack<>();
 private Stack<Integer> minStack = new Stack<>();

 private int min = Integer.MAX_VALUE;

 /** initialize your data structure here. */
 public MinStack() {

 }

 public void push(int val) {
  dataStack.add(val);
  min = Math.min(min, val);

  // 重复的话相当于距离最小值之前的防护距离
  minStack.add(min);
 }

 public void pop() {
  dataStack.pop();
  minStack.pop();

  // 当minStack为空时，说明dataStack中的所有值都被被排出去了，此时需要重新设定最小值
  // 不为空时，min为次小值
  min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
 }

 public int top() {
  return dataStack.peek();
 }

 public int getMin() {
  return minStack.peek();
 }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
 * param_4 = obj.getMin();
 */
// @lc code=end
