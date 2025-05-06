import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] grid;
    static boolean[][] visited;
    static int answer = 0;

    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int ii = 0; ii < m; ii++) {
                grid[i][ii] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = true;
        dfs(0, 0);

        System.out.println(answer);

    }

    static void dfs(int x, int y) {
        if (x == n-1 && y == m-1) {
            answer = 1;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isNotRange(nx, ny)) continue;
            if (visited[nx][ny]) continue;
            if (grid[nx][ny] == 0) continue;

            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }
    static boolean isNotRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }
}

//1 2
