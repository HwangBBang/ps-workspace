// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] grid;
    static final int N = 5;
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};
    static int answer;
    static Map<Character, Integer> map;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        grid = new char[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 1; j <= N ; j++) {
                grid[i][j] = line[j - 1];
            }
        }

        map = new HashMap<>();
        visited = new boolean[N + 1][N + 1];
        answer = 0;


        backtracking(0, 0, 0, 0);

        System.out.println(answer);
    }

    static void backtracking(int step, int start, int sx, int sy) {
        if (map.getOrDefault('Y', 0) >= 4) return;

        if (step == 7) {
            if (isConnected(sx,sy)){
                answer ++;
            }
            return;
        }

        int cx = (start / 5) + 1;
        int cy = (start % 5) + 1;
        if (start >= 25) return;
        if(visited[cx][cy]) return;
        char cur = grid[cx][cy];

        // 선택 O
        visited[cx][cy] = true;
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        if (step == 0) {
            backtracking(step + 1, start + 1, cx, cy);
        } else {
            backtracking(step + 1, start + 1, sx, sy);
        }
        visited[cx][cy] = false;
        int cnt = Math.max(0, map.get(cur) - 1);
        map.put(cur, cnt);

        // 선택 X
        backtracking(step, start + 1, sx, sy);
    }


    static boolean outOfRange(int x, int y) {
        return x < 1 || x > N || y < 1 || y > N;
    }

    static boolean isConnected(int x, int y) {

        boolean[][] v = new boolean[N + 1][N + 1];
        Queue<int[]> que = new ArrayDeque<>();

        v[x][y] = true;
        que.add(new int[]{x, y});

        int cnt = 1;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];

                if (outOfRange(nx, ny)) continue;
                if (!visited[nx][ny]) continue;
                if (v[nx][ny]) continue;

                cnt++;
                v[nx][ny] = true;
                que.add(new int[]{nx, ny});
            }
        }

        return cnt == 7;
    }
}

/*
 0 0 0 0 0 0
 0 1 2 3 4 5
 0 6 7 8 9 10
 0 0 0 0 0 0
 0 0 0 0 0 0

*/
