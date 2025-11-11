// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, l, r;
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        grid = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = 0;
        while (true) {
            if (!isOpen()) break;
            day ++;
        }
        System.out.println(day);

    }
    private static boolean isOpen() {
        visited = new boolean[n + 1][n + 1];
        boolean isMoved = false;

        for (int x = 1; x <= n ; x++) {
            for (int y = 1; y <= n; y++) {
                if (visited[x][y]) continue;
                List<int[]> group = bfs(new int[]{x, y});
                if (group.size() >= 2) {
                    isMoved = true;
                    int cnt = group.size();
                    int sum = 0;
                    for (int[] ints : group) {
                        sum += grid[ints[0]][ints[1]];
                    }
                    for (int[] ints : group) {
                        grid[ints[0]][ints[1]] = sum / cnt;
                    }
                }
            }
        }

        if (!isMoved) return false;
        return true;
    }

    private static List<int[]> bfs(int[] cur) {
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> result = new ArrayList<>();

        visited[cur[0]][cur[1]] = true;
        result.add(cur);
        queue.add(cur);

        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            int x = c[0], y = c[1];
            for (int k = 0; k < dx.length; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (outOfRange(nx,ny)) continue;
                if (visited[nx][ny]) continue;
                if (isRange(grid[x][y], grid[nx][ny])) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    result.add(new int[]{nx, ny});
                }
            }
        }

        return result;
    }

    private static boolean isRange(int v1, int v2) {
        int diff = Math.abs(v1 - v2);
        return l <= diff && diff <= r;
    }
    private static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }
}
/*

*/

