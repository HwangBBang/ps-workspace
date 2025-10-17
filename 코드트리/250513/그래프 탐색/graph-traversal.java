import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] grid;
    static boolean[] visited;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            grid[x][y] = 1;
            grid[y][x] = 1;
        }
        visited[0] = true; 
        dfs(0);
        
        System.out.println(answer.size());

    }

    static void dfs(int curNode){
        for (int i = 0; i < n; i ++){
            if (visited[i]) continue;
            if (grid[curNode][i] == 0) continue;
            
            visited[i] = true; 
            answer.add(i);
            dfs(i);

        }
    }
}

//1 2
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] grid;
    static boolean[] visited;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            grid[x][y] = 1;
            grid[y][x] = 1;
        }

        visited[0] = true;
        dfs(0);

        System.out.println(answer.size());

    }

    static void dfs(int start) {
        for (int i = 0; i < n; i++) {
            if (!visited[i] && grid[start][i] == 1) {
                visited[i] = true;
                answer.add(i);
                dfs(i);

            }
        }
    }
}

//1 2

*/