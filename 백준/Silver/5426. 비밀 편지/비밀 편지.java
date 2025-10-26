// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            char[] res = br.readLine().toCharArray();
            n = (int)Math.sqrt(res.length);

            char[][] grid = new char[n][n];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = res[idx];
                    idx++;
                }
            }
            sb = new StringBuilder();
            char[][] result = rotate90(grid);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(result[i][j]);
                }
            }
            System.out.println(sb);
        }
    }

    static char[][] rotate90(char[][] source) {
        char[][] result = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[(n-1)-i][j] = source[j][i];
            }
        }
        return result;
    }

}
