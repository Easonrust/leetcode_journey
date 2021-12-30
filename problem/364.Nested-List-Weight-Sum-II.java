/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 *
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to
 * it.
 * public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
class Solution {
 int res;
 int maxDepth;

 public int depthSumInverse(List<NestedInteger> nestedList) {
  res = 0;
  for (NestedInteger n : nestedList) {
   maxDepth = Math.max(maxDepth, findMaxDepth(n, 1));
  }

  for (NestedInteger n : nestedList) {
   dfs(n, 1);
  }
  return res;
 }

 private void dfs(NestedInteger ni, int depth) {
  if (ni.isInteger()) {
   res += ni.getInteger() * (maxDepth - depth + 1);
   return;
  }

  List<NestedInteger> list = ni.getList();
  for (NestedInteger n : list) {
   dfs(n, depth + 1);
  }
 }

 private int findMaxDepth(NestedInteger ni, int depth) {
  if (ni.isInteger()) {
   return depth;
  }
  int res = 0;
  List<NestedInteger> list = ni.getList();
  for (NestedInteger n : list) {
   res = Math.max(res, findMaxDepth(n, depth + 1));
  }
  return res;
 }
}