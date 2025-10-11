
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int n,m, answer;
    static int[][] dp, grid;
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        answer = dfs(1, 1);
        System.out.println(answer);
    }

    static int dfs(int i, int j) {
        if (i == n && j == m) return 1;
        if (dp[i][j] != -1) return dp[i][j];

        int result = 0;
        for (int k = 0; k < dx.length; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (outOfRange(nx, ny)) continue;
            if (grid[i][j] <= grid[nx][ny]) continue;

            result += dfs(nx, ny);
        }
        dp[i][j] = result;
        return result;

    }
    static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > m;
    }
}
