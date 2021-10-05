import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1048 lang=java
 *
 * [1048] Longest String Chain
 */

// @lc code=start
class Solution {
    public int longestStrChain(String[] words) {
        int res=1;
        Arrays.sort(words,new Comparator<String>(){
         @Override
         public int compare(String o1,String o2){
          return o1.length()-o2.length();
         }
        });
        Map<String,Integer> map=new HashMap<>();
        for(String word:words){
         int l=1;
         for(int i=0;i<word.toCharArray().length;++i){
          String tmp=word.substring(0, i)+word.substring(i+1);
          l=Math.max(l,map.getOrDefault(tmp, 0)+1);
         }
         map.put(word, l);
         res=Math.max(res,l);
        }
        return res;
    }
}
// @lc code=end
// 相比与经典的f[i]表示以第i个单词结尾时的最优解，在这里我才用的是f[word]表示以单词word结尾的最优解，那么对于当前处理的word，我们可以枚举其中的每个字符，然后尝试删去这个字符之后得到前置字符串tmp，那么就有f[word] = max(f[word], f[tmp] + 1)。这样做的好处是传统f[i]表示下，状态转移需要枚举words[j]并判断words[i]能否由words[j]形成，而是用f[word]表示则只需要检测特定的几个f[tmp]，效率上会更好一点。
// 典型的动态规划问题

