import java.util.*;

class Solution {
    static int graphSize = 0;
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++){
            graph.put(i, new ArrayList<>());
        }
        
        for (int [] wire : wires){
            int p = wire[0], c = wire[1];
            graph.get(p).add(c);
            graph.get(c).add(p);
        }
        
        int minDiff = Integer.MAX_VALUE;
        
        for (int [] wire : wires){
            int p = wire[0], c = wire[1];
            graph.get(p).remove(Integer.valueOf(c));
            graph.get(c).remove(Integer.valueOf(p));
            
            boolean [] visited = new boolean[n + 1];
            
            dfs(p,graph,visited);
            int otherSize = n - graphSize;
            
            minDiff = Math.min(minDiff,Math.abs(otherSize - graphSize));
            
            graph.get(p).add(c);
            graph.get(c).add(p);
            graphSize = 0;
        }
        
        return minDiff;
    }
    
    static void dfs(int startNode, 
                    Map<Integer, List<Integer>> graph,
                    boolean [] visited){
        graphSize++;
        visited[startNode] = true;
        for (int nextNode : graph.get(startNode)){
            if(visited[nextNode]) continue;
            dfs(nextNode, graph, visited);
        }
        
    }
}