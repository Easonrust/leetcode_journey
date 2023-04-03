class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegrees = new HashMap<>();
        for(int i=0; i<n; ++i){
            String recipe = recipes[i];
            int indegree = ingredients.get(i).size();
            indegrees.put(recipe, indegree);
            for(String ingredient:ingredients.get(i)){
                graph.putIfAbsent(ingredient, new ArrayList<>());
                graph.get(ingredient).add(recipe);
            }
        }
        Queue<String> q = new LinkedList<>();
        for(String supply:supplies){
            q.offer(supply);
        }
        List<String> res = new ArrayList<>();
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; ++i){
                String cur = q.poll();
                if(!graph.containsKey(cur)){
                    continue;
                }
                for(String next:graph.get(cur)){
                    indegrees.put(next, indegrees.get(next)-1);
                    if(indegrees.get(next)==0){
                        res.add(next);
                        q.offer(next);
                    }
                }
            }
        }
        return res;
    }
}