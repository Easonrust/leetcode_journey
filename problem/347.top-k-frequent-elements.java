import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (63.13%)
 * Likes:    5628
 * Dislikes: 284
 * Total Accepted:    638.2K
 * Total Submissions: 1M
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * 
 * 
 * 
 * Follow up: Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 * 
 */

// @lc code=start
class Solution {
 public int[] topKFrequent(int[] nums, int k) {
  HashMap<Integer, Integer> frequencyForNum = new HashMap<>();
  for (int num : nums) {
   frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
  }
  List<Integer>[] buckets = new ArrayList[nums.length + 1];
  // 这里要注意数组序号
  for (int key : frequencyForNum.keySet()) {
   int frequency = frequencyForNum.get(key);
   if (buckets[frequency] == null) {
    buckets[frequency] = new ArrayList<>();
   }
   buckets[frequency].add(key);
  }

  ArrayList<Integer> topK = new ArrayList<>();
  for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
   if (buckets[i] == null) {
    continue;
   }
   if (buckets[i].size() <= (k - topK.size())) {
    topK.addAll(buckets[i]);
   } else {
    topK.addAll((buckets[i].subList(0, k - topK.size())));
   }
  }
  int[] result = new int[k];
  for (int i = 0; i < result.length; i++) {
   result[i] = topK.get(i);
  }

  return result;
 }
}
// @lc code=end
