import java.util.*;

class Solution {
    static int [][] grid;
    static boolean [][] visited;
    static List<Node> stack;
    static int N;
    
    static class Node{
        int x;
        int y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        
        grid = computers;  // 를 static 하게 글로벌로 못빼나?
        visited = new boolean[n][n];
        List<List<Node>> network = new ArrayList<>();
        
        for(int i = 0; i < n; i ++){
            for(int ii = 0; ii < n; ii ++){
                if (grid[i][ii] == 1 && !visited[i][ii]){
                    stack = new ArrayList<>();
                        
                    getNetworkCount(i);
                    network.add(stack);
                }
            }
        }
        
        answer = network.size();
            
        return answer;
    }
    
    static void getNetworkCount(int x){
        
        for(int i = 0; i < N; i++){
            if (grid[x][i] == 0) continue;
            if (visited[x][i]) continue;
            
            visited[x][i] = true;
            visited[i][x] = true;
            
            stack.add(new Node(x,i));
            getNetworkCount(i);
        }
        
        
    }
}
/*
[
    [1, 1, 0], 
    [1, 1, 0], 
    [0, 0, 1]
]
*/ 