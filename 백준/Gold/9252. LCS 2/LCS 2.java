// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();
        lcs(first, second);

        System.out.println(sb);
    }

    static void lcs(String first, String second) {
        int n = first.length();
        int m = second.length();

        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (firstArr[i - 1] == secondArr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int len = dp[n][m];
        sb.append(len).append("\n");

        if (len == 0) return;

        StringBuilder tmp = new StringBuilder();

        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (firstArr[i - 1] == secondArr[j - 1]) {
                tmp.append(firstArr[i - 1]);
                i--;
                j--;
            } else {
                if (dp[i - 1][j] >= dp[i][j - 1]) i--;
                else j--;
            }
        }

        sb.append(tmp.reverse());
    }

}
/*

*/