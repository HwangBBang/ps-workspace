// package baekjoon.bronze;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/bronze/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String source = br.readLine();
        int n = source.length();

        int r = -1;
        for (int i = 1; i*i <= n; i++) {
            if (n % i == 0) r = Math.max(r, i);
        }
        int c = n / r;

        char[][] grid = new char[r][c];

        int idx = 0;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                grid[j][i] = source.charAt(idx++);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(grid[i][j]);
            }
        }

        System.out.println(sb);
    }
}

/*

정인이  R<=C이고, R*C=N인 R과 C
R이 큰 값 우선
최대 100글자 => N 은 최대 100
 */



