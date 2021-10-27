/*
 * @lc app=leetcode id=502 lang=java
 *
 * [502] IPO
 */

// @lc code=start
class Solution {
 class Project {
  int p;
  int c;

  Project(int profit, int capital) {
   p = profit;
   c = capital;
  }
 }

 public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
  List<Project> projects = new ArrayList<>();
  for (int i = 0; i < profits.length; ++i) {
   Project project = new Project(profits[i], capital[i]);
   projects.add(project);
  }
  Collections.sort(projects, new Comparator<>() {
   @Override
   public int compare(Project o1, Project o2) {
    return o2.p - o1.p;
   }
  });
  int sum = w;
  while (k > 0) {
   int i = 0;
   int end = projects.size();
   while (i < end && projects.get(i).c > sum) {
    i++;
   }

   if (i == end) {
    break;
   }
   sum += projects.get(i).p;
   projects.remove(i);
   k--;
  }
  return sum;
 }
}
// @lc code=end
// greedy, 但是使用priority queue可以优化到O(nlogn)
