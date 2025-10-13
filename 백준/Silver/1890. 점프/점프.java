
import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = new int[]{0, 1};
    static int[] dy = new int[]{1, 0};
    static int[][] grid ;
    static long[][]dp;
    static int n;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[n-1][n-1] = 1;
        solution(0, 0);
        System.out.println(dp[0][0]);
    }

    private static void solution(int x, int y) {
        if (dp[x][y] != -1) return;

        int w = grid[x][y];
        
        dp[x][y] = 0;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i] * w;
            int ny = y + dy[i] * w;
            if (outOfRange(nx, ny)) continue;

            if (dp[nx][ny] == -1) solution(nx, ny);
            dp[x][y] += dp[nx][ny];
        }
    }

    private static boolean outOfRange(int x, int y) {
        return 0 > x || x >= n || 0 > y || y >= n;
    }
}

/*
    (0, 0) -> (n-1, n-1)
    경로의 개수는 263-1보다 작거나 같다
    2^60 byte

    2^10 -> 1024
    2^10 -> 1024
    2^10 -> 1024
*/
