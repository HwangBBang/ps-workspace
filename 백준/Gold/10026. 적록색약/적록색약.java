// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int n;
    static char[][] grid;
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        grid = new char[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                grid[i][j + 1] = line[j];
            }
        }
        int normalResult = getArea(false);
        int disableResult = getArea(true);

        System.out.println(normalResult + " " + disableResult);
    }

    static int getArea(boolean isDisable) {
        boolean[][] visited = new boolean[n + 1][n + 1];
        int area = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (visited[i][j]) continue;
                if (isDisable){  bfsForDisable(visited, new int[]{i, j});}
                else{ bfsForNormal(visited, new int[]{i, j});}
                area ++;
            }
        }
        return area;
    }

    static void bfsForNormal(boolean[][] visited, int[] start) {
        Queue<int[]> que = new ArrayDeque<>();
        int x = start[0], y = start[1];
        char pivot = grid[x][y];
        visited[x][y] = true;
        que.add(start);
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (outOfRange(nx,ny)) continue;
                if (visited[nx][ny]) continue;
                if (grid[nx][ny] == pivot) {
                    visited[nx][ny] = true;
                    que.add(new int[]{nx, ny});
                }
            }
        }


    }

    static void bfsForDisable(boolean[][] visited, int[] start) {
        Queue<int[]> que = new ArrayDeque<>();
        int x = start[0], y = start[1];
        char pivot = grid[x][y];

        visited[x][y] = true;
        que.add(start);
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (outOfRange(nx,ny)) continue;
                if (visited[nx][ny]) continue;
                if (pivot == 'R' || pivot == 'G') {
                    if (grid[nx][ny] == 'R' || grid[nx][ny] == 'G') {
                        visited[nx][ny] = true;
                        que.add(new int[]{nx, ny});
                    }
                } else {
                    if (grid[nx][ny] == pivot) {
                        visited[nx][ny] = true;
                        que.add(new int[]{nx, ny});
                    }
                }
            }
        }

    }

    static boolean outOfRange(int x, int y) {
        return 1 > x || n < x || 1 > y || n < y;
    }
}


/*
    N 이 작음

    적록색약은 빨간색과 초록색
    R == G


 */