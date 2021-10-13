// class Solution {
//     public boolean find132pattern(int[] nums) {
//         List<int[]> intervals=new ArrayList<>();
//         int i=1,s=0;
//         while(i<nums.length){
            
//             // 检查是否是一个峰值
//             if(nums[i]<nums[i-1]){
//                 if(s<i-1){
//                     intervals.add(new int[]{nums[s],nums[i-1]});
//                 }
//                 //更新谷值
//                 s=i;
//             }
//             for(int []a:intervals){
//                 if(nums[i]>a[0]&&nums[i]<a[1]){
//                     return true;
//                 }
//             }
//             i++;
        
//         }
//         return false;
//     }
// }
// k一定在i和j在峰值和谷值的中间

public class Solution {
 public boolean find132pattern(int[] nums) {
     if (nums.length < 3)
         return false;
     Stack < Integer > stack = new Stack < > ();
     int[] min = new int[nums.length];
     min[0] = nums[0];
     for (int i = 1; i < nums.length; i++)
         min[i] = Math.min(min[i - 1], nums[i]);
     for (int j = nums.length - 1; j >= 0; j--) {
         if (nums[j] > min[j]) {
             while (!stack.isEmpty() && stack.peek() <= min[j])
                 stack.pop();
             if (!stack.isEmpty() && stack.peek() < nums[j])
                 return true;
             stack.push(nums[j]);
         }
     }
     return false;
 }
}
// 使用栈的方法更节省时间
