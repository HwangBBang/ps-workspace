
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = new int[]{0, 1, 1};
    static int[] dy = new int[]{1, 1, 0};
    static int n, answer;
    static final int D0 = 0, D1 = 1, D2 = 2;
    static final int[] candidateD0 = new int[]{0, 1};
    static final int[] candidateD1 = new int[]{0, 2};
    static final int[] candidateD2 = new int[]{1, 2};

    static int[][] grid;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        grid = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        dp[n][n][D0] = dp[n][n][D1] = dp[n][n][D2] = 1;
        solution(1, 2, D0);

        System.out.println(dp[1][2][D0]);

    }

    static void solution(int x, int y, int d) {
        if (dp[x][y][d] != -1) return;

        dp[x][y][d] = 0;
        // 가로 이동
        if (d == D0 || d == D1) {
            if (checkRight(x, y)) {
                if (dp[x][y+1][D0] == -1) solution(x, y + 1, D0);

                dp[x][y][d] += dp[x][y + 1][D0];
            }
        }

        // 아래 이동
        if (d == D1 || d == D2) {
            if (checkDown(x, y)) {
                if (dp[x+1][y][D2] == -1) solution(x + 1, y, D2);

                dp[x][y][d] += dp[x+1][y][D2];
            }
        }

        // 대각 이동
        if (checkDiagonal(x, y)) {
            if (dp[x+1][y+1][D1] == -1)  solution(x + 1, y + 1, D1);

            dp[x][y][d] += dp[x+1][y+1][D1];
        }
    }


    static boolean checkRight(int x, int y) {
        return y + 1 <= n && grid[x][y+1] == 0;
    }

    static boolean checkDiagonal(int x, int y) {
        return x + 1 <= n && y + 1 <= n && grid[x + 1][y] == 0 && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0;
    }

    static boolean checkDown(int x, int y) {
        return x + 1 <= n && grid[x + 1][y] == 0;
    }
}

/*


*/