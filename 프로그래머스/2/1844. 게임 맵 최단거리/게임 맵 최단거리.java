import java.util.*;

class Solution {
    static int[][] grid;
    static boolean[][] visited;
    static int[][] dist;
    static int n, m;
    static int answer = -1;
    static Queue<Position> queue;
    
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
    static class Position{
        int x; int y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] maps) {
        grid = maps;
        n = grid.length;  
        m = grid[0].length;
        
        visited = new boolean[n][m];
        dist = new int[n][m];
        queue = new LinkedList<>();
        
        queue.add(new Position(0,0));
        visited[0][0] = true;
        dist[0][0] = 1;
            
        bfs();
        return answer;
    }
    
    static void bfs(){
        
        while(!queue.isEmpty()){    
            Position current = queue.poll();
            int x = current.x, y = current.y;
            
            if (x == n-1 && y == m-1) {
                answer = dist[n-1][m-1];
                return;
            }
            for(int i = 0; i < 4; i ++){
                int nx = x + dx[i], ny = y + dy[i];
                
                if(isNotRange(nx,ny)) continue;
                if(visited[nx][ny]) continue;
                if(grid[nx][ny] == 0) continue;
                
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                queue.add(new Position(nx,ny));
                
            }
        }
    }

    
    static boolean isNotRange(int x, int y){
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}