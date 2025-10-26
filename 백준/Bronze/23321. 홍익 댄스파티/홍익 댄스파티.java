// package baekjoon.bronze;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/bronze/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        char[][] s = new char[5][];
        for (int r = 0; r < 5; r++) s[r] = br.readLine().toCharArray();
        int m = s[0].length;

        char[][] result = new char[5][m];
        for (int r = 0; r < 5; r++) System.arraycopy(s[r], 0, result[r], 0, m);

        final char[] READY = {'.','o','m','l','n'};
        final char[] JUMP  = {'o','w','l','n','.'};
        final char[] SEAT  = {'.','.', 'o','L','n'};

        for (int c = 0; c < m; c++) {
            char key = s[2][c];
            if (key == 'm') {
                for (int r = 0; r < 5; r++)
                    result[r][c] = JUMP[r];
            } else if (key == 'l') {
                for (int r = 0; r < 5; r++)
                    result[r][c] = READY[r];
            } else {
                for (int r = 0; r < 5; r++)
                    result[r][c] = SEAT[r];
            }
        }

        StringBuilder out = new StringBuilder();
        for (int r = 0; r < 5; r++)
            out.append(result[r]).append('\n');
        System.out.print(out);
    }
}

// 도약 준비 -> 도약 중, 도약 중 -> 도약 준비로 바뀐다. 착석은 변경 ㄴㄴ

