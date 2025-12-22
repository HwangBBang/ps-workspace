// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 2];
        int[] p = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());

        }
        int[] dp = new int[n + 2];

//       nxt = c + times[c]
        for (int d = 1; d <= n + 1; d++) {
            // 전이
            dp[d] = Math.max(dp[d], dp[d - 1]);

            // 갱신
            int nd = d + t[d];
            if (nd > n + 1) continue;
            dp[nd] = Math.max(dp[nd], dp[d] + p[d]);
        }
        int answer = dp[n + 1];
        System.out.println(answer);
    }

}

/*
    n일 동안 최대.
    k 일동안 최대
    끝나는 날이 n + 1 이하여야한다.

    상담 한다 vs 상담 안한다.
    상담 한다. dp[nd] = max(dp[nd], dp[d] + p[d])
    상담 안한다. dp[nd] = max(dp[nd] , dp[nd -1])


*/
