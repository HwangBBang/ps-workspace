// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static int n, answer;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = -1;
        backtracking(0, grid);
        System.out.println(answer);

    }

    static void backtracking(int step, int[][]grid) {
        if (step == 5) {
            answer = Math.max(answer, getMax(grid));
            return;
        }
        for (int d = 0; d < 4; d++) {
            backtracking(step + 1, simulation(d, grid));
        }
    }

    static int[][] simulation(int dir, int[][] grid) {
        int[][] next = copy(grid);
        if (dir == 0) { // <-
            for (int i = 0; i < n; i++) {
                int[] line = grid[i];
                next[i] = mergeLine(line);
            }
        } else if (dir == 1) {
            for (int i = 0; i < n; i++) {
                int[] line = reverse(grid[i]);
                next[i] = reverse(mergeLine(line));
            }
        } else if (dir == 2) {
            for (int j = 0; j < n; j++) {
                int[] line = new int[n];
                for (int i = 0; i < n; i++) {
                    line[i] = grid[i][j];
                }
                int[] merged = mergeLine(line);
                for (int i = 0; i < n; i++) {
                    next[i][j] = merged[i];
                }
            }
        } else if (dir == 3) {
            for (int j = 0; j < n; j++) {
                int[] line = new int[n];
                for (int i = 0; i < n; i++) {
                    line[i] = grid[i][j];
                }
                int[] merged = reverse(mergeLine(reverse(line)));
                for (int i = 0; i < n; i++) {
                    next[i][j] = merged[i];
                }
            }
        }

        return next;
    }

    static int[] removeZero(int[] line) {
        int[] result = new int[n];
        int w = 0;
        for (int i = 0; i < n; i++) {
            if (line[i] != 0) {
                result[w++] = line[i];
            }
        }
        return result;
    }

    static int[] mergeLine(int[] line) {
        int[] zipped = removeZero(line);

        int[] result = new int[n];
        int i = 0;
        int w = 0;

        while (i < n && zipped[i] != 0) {
            if (i + 1 < n) {
                if (zipped[i] == zipped[i + 1]) {
                    result[w++] = zipped[i] * 2;
                    i += 2;
                    continue;
                }
            }
            result[w++] = zipped[i];
            i += 1;
        }

        return result;
    }

    static int[][] copy(int[][] src) {
        int[][] next = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(src[i], 0, next[i], 0, n);
        }
        return next;
    }

    static int[] reverse(int[] line) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = line[n - i - 1];
        }
        return result;
    }

    static int getMax(int[][] grid) {
        int result = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, grid[i][j]);
            }
        }
        return result;
    }
}

/*

첫째 줄에 보드의 크기 N (1 ≤ N ≤ 20)이 주어진다.

둘째 줄부터 N개의 줄에는 게임판의 초기 상태가 주어진다.
0은 빈 칸을 나타내며, 이외의 값은 모두 블록을 나타낸다.
블록에 쓰여 있는 수는 2보다 크거나 같고,
1024보다 작거나 같은 2의 제곱꼴이다. 블록은 적어도 하나 주어진다.

가 N×N 이다. 보드의 크기와 보드판의 블록 상태가 주어졌을 때, 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값?

다 해봐야할듯 ? (n 사이즈 작음)
=> 백트랙킹?

0 2 2 => 0 0 4

2 0 4 => 0 2 4

2 2 4 => 0 4 4

시프트 동작은 크게 2가지로 구분된다.

1. 압축 0을 제거
2. 병합

 */
