// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[1] = 0; // 목표
        parent[1] = -1;

        for (int i = 2; i <= n; i++) {

            int candidate1 = dp[i - 1] + 1;
            int candidate2 = i % 2 == 0 ? dp[i / 2] + 1 : INF;
            int candidate3 = i % 3 == 0 ? dp[i / 3] + 1 : INF;

            dp[i] = Math.min(Math.min(candidate1, candidate2), candidate3);

            if (dp[i] == candidate1) {
                parent[i] = i - 1;
            } else if (dp[i] == candidate2) {
                parent[i] = i / 2;
            } else if (dp[i] == candidate3) {
                parent[i] = i / 3;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dp[n]).append("\n");

        int idx = n;
        sb.append(idx).append(" ");
        while (parent[idx] != -1) {
            sb.append(parent[idx]).append(" ");
            idx = parent[idx];
        }
        System.out.println(sb);
    }

}


/*
    전형적인 DP 문제 + 역추적
    3X -> X
    2X -> X
    X+1 -> X

    목표는 1
 */