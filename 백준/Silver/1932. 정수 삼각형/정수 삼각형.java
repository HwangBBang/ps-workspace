
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], -1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            dp[i][i] = dp[i - 1][i-1] + grid[i][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] =  grid[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }
        int answer = -1;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }

        System.out.println(answer);
    }
}

/*
    dp[i][j] = 해당 지점까지 최대 합

    dp[i][j] =  grid[i][j] + max(dp[i-1][j-1], dp[i-1][j])
*/
