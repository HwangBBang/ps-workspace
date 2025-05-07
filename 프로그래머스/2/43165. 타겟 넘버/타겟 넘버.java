import java.util.*;

class Solution {
    static List<Integer> stack; 
    static int answer,n = 0;
    static int [][] grid; 
    static boolean [][] visited; 
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        
        grid = new int[n][2];
        visited = new boolean[n][2];
        
        for (int i = 0; i < n; i ++){
            grid[i][0] = numbers[i];
            grid[i][1] = -1 * numbers[i];
        }
        
        stack = new ArrayList<Integer>();
        choice(0, target);
        return answer;
    }
    
    
    static void choice(int idx, int target){
        if (idx >= n){
    
            if (isTarget(target))answer ++;
            
            return; 
        }
        
        
        for (int i = 0; i < 2; i ++){
            
            // 가도 되는지 ?
            if(visited[idx][i]) continue;   
            
            stack.add(grid[idx][i]); 
            choice(idx + 1, target);    // 다음거로 진행  
            stack.remove(stack.size()-1);
        }
    }
    
    
    static boolean isTarget(int target){
        int result = 0;
        for (int e : stack){
            result += e;
        }
        
        return target == result;
    }
}