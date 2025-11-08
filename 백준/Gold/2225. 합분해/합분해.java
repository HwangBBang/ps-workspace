// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) dp[i][1] = 1;
        for (int i = 0; i <= k; i++) dp[0][i] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1_000_000_000;
            }
        }
        System.out.println(dp[n][k]);
    }

}
