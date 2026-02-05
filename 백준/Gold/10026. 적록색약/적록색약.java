// package jimin;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] grid;
    static boolean[][] visited;

    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/B10026input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 입력
        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        // 입력 끝


        visited = new boolean[n][n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;

                char color = grid[i][j];
                bfs(color, i, j);
                cnt += 1;
            }
        }

        visited = new boolean[n][n];
        int rgclCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;

                char color = grid[i][j];
                grclBfs(color, i, j);
                rgclCnt += 1;
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append(" ").append(rgclCnt);
        System.out.println(sb);
    }

    static void bfs(char color, int x, int y) { // 현재 칼라, 시작 좌표
        Queue<int[]> que = new ArrayDeque<>();

        visited[x][y] = true;
        que.add(new int[]{x, y});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (outOfRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (grid[nx][ny] != color) continue;

                visited[nx][ny] = true;
                que.add(new int[]{nx, ny});
            }
        }
    }

    static void grclBfs(char color ,int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();

        visited[x][y] = true;
        que.add(new int[]{x, y});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (outOfRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (!rgcl(color , grid[nx][ny])) continue;

                visited[nx][ny] = true;
                que.add(new int[]{nx, ny});
            }
        }
    }

    static boolean rgcl(char color, char next) {
        boolean rg = (color == 'R' || color == 'G') && (next == 'R' || next == 'G');
        boolean b = color == 'B' && next == 'B';
        return rg || b;
    }

    static boolean outOfRange(int nx,int ny) {
        return nx < 0 || nx >= n || ny < 0 || ny >= n;
    }
}

