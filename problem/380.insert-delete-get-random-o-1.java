/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
class RandomizedSet {

 Map<Integer, Integer> map;
 List<Integer> list;
 Random rand;

 public RandomizedSet() {
  rand = new Random();
  map = new HashMap<>();
  list = new ArrayList<>();
 }

 public boolean insert(int val) {
  if (map.containsKey(val)) {
   return false;
  }
  map.put(val, list.size());
  list.add(val);
  return true;
 }

 public boolean remove(int val) {
  if (!map.containsKey(val)) {
   return false;
  }

  // 将最后一个元素填补上去，可以保证其他元素的idx永远不变
  int lastElement = list.get(list.size() - 1);
  int idx = map.get(val);
  list.set(idx, lastElement);
  map.put(lastElement, idx);
  list.remove(list.size() - 1);
  map.remove(val);
  return true;
 }

 public int getRandom() {
  return list.get(rand.nextInt(list.size()));
 }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end
