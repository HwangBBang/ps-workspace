// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int SIZE = 1_000_000;
    static final int DIV = 1_000_000_009;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] q = new int[T];

        for (int t = 0; t < T; t++) {
            q[t] = Integer.parseInt(br.readLine());
        }

        long[] dp = new long[SIZE + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= SIZE; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % DIV;

        }

        for (int i = 0; i < T; i++) {
            sb.append(dp[q[i]]).append("\n");
        }
        System.out.println(sb);

    }

}

/*
    1 : 1

    2 : 1 1
      : 2

    3 : 1 1 1
      : 2 1
      : 1 2
      : 3

    4 : (dp[1] + 3) + (dp[2] + 2) + (dp[3] + 1)
      : 1 + 2 + 4 => 7

    5 : dp[4] + dp[3] + d[2]
      : 7 + 4 + 2 = => 13

    6 : dp[5] + dp[4] + d[3]
      : 13 + 7 + 4 = => 24

    7 : dp[6] + dp[5] + d[4]
      : 24 + 13 + 7 = => 44

*/