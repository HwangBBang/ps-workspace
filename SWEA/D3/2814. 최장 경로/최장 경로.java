import java.util.*;
import java.io.FileInputStream;

class Solution{
   	static boolean[][] grid;
    static boolean[] visited;
    static int n, answer;
    
	public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
		int T;        
		T=sc.nextInt();
    
		for(int test_case = 1; test_case <= T; test_case++) {
      		n = sc.nextInt(); int m = sc.nextInt();            

            grid = new boolean[n+1][n+1];
			visited = new boolean[n+1];
            
            for (int i = 0; i < m; i ++){
                int u = sc.nextInt(); int v = sc.nextInt();
                grid[u][v] = true; grid[v][u] = true;
            }
            answer = 1;
            for (int start = 1; start <= n; start++){
            	Arrays.fill(visited, false);
                visited[start] = true;
                dfs(start, 1);   
            }
            
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
    
    static void dfs(int start, int len){
        if (answer == n) return;
        if (len > answer) answer = len; 
        
        for (int end = 1; end <= n; end ++){
            if (!grid[start][end]) continue;
            if (visited[end]) continue;
            visited[end] = true;
            dfs(end, len+1);
            visited[end] = false;
        }
    }
}