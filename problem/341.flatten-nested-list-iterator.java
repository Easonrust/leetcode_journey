/*
 * @lc app=leetcode id=341 lang=java
 *
 * [341] Flatten Nested List Iterator
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */
public class NestedIterator implements Iterator<Integer> {

 List<Integer> ints;

 int i;

 public NestedIterator(List<NestedInteger> nestedList) {
  ints = new ArrayList<>();
  dfs(nestedList);
  i = 0;
 }

 public void dfs(List<NestedInteger> list) {
  for (NestedInteger e : list) {
   if (e.isInteger()) {
    ints.add(e.getInteger());
   } else {
    dfs(e.getList());
   }
  }
 }

 @Override
 public Integer next() {
  int res = ints.get(i);
  i = i + 1;
  return res;
 }

 @Override
 public boolean hasNext() {
  if (i < ints.size()) {
   return true;
  }
  return false;
 }
}

// DFS

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
 * = i.next();
 */
// @lc code=end
