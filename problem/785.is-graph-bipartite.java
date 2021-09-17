/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors=new int[graph.length];
        Arrays.fill(colors,-1);
        for(int i=0;i<graph.length;++i){

         // 这句判断主要针对非连通图加的，并且确保上0色的都是之前没有上过颜色的节点
         if(colors[i]==-1){
          if(!checkIsBipartite(graph,i,0,colors)){
           return false;
          }
         }
        }
        return true;
    }

    private boolean checkIsBipartite(int[][] graph,int curNode, int curColor,int[] colors){
     if(colors[curNode]!=-1){
      return colors[curNode]==curColor;
     }

     colors[curNode]=curColor;

     for(int nextNode:graph[curNode]){

      // 对相邻节点全部上色为1色
      if(!checkIsBipartite(graph,nextNode,1-curColor,colors)){
       return false;
      }
     }
     return true;
    }
}
// @lc code=end
// 如果可以用两种颜色对图中的节点进行着色，并且保证相邻的节点颜色不同，那么这个图就是二分图

