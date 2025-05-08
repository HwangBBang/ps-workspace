import java.util.*;

class Solution {
    static char[][] grid;
    static boolean[][] visited;
    static int n,m,temp;
    static List<Integer> answer = new ArrayList<>();
    
    static int[] dx = {0, 1, 0 ,-1};
    static int[] dy = {1, 0, -1 ,0};
    
    
    public int[] solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        
        grid = new char[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++){
            grid[i] = maps[i].toCharArray();
        }
        
        for (int i = 0; i < n; i++){
            for (int ii = 0; ii < m; ii++){
                // answer.clear();
                if(grid[i][ii] == 'X') continue;
                if(visited[i][ii]) continue;
                
                temp = grid[i][ii] - '0';
                visited[i][ii] = true;
                dfs(i,ii);
                answer.add(temp);
            }    
        }
        
        if(answer.isEmpty()) return new int[]{-1};
        
        Collections.sort(answer);
        
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
    
    static void dfs (int x, int y){
        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(isNotRange(nx,ny)) continue;
            if(grid[nx][ny] == 'X') continue;
            if(visited[nx][ny]) continue;
            
            
            
            visited[nx][ny] = true;
            temp += grid[nx][ny] - '0';
            dfs(nx,ny);
        }
           
    }
    
    static boolean isNotRange(int x, int y){
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}