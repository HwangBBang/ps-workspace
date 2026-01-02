// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = new int[]{0, 1, 0, - 1};
    static final int[] dy = new int[]{1, 0, -1, 0};
    static int m, n;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean[][] grid = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                grid[x][y] = true;
            }
            int answer = solution(grid);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static int solution(boolean[][] grid) {
        visited = new boolean[n][m];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!grid[i][j]) continue;
                if (visited[i][j]) continue;
                bfs(i, j, grid);
                result++;
            }
        }
        return result;
    }

    static void bfs(int sx, int sy, boolean[][]grid) {
        Queue<int[]> que = new ArrayDeque<>();
        visited[sx][sy] = true;
        que.add(new int[]{sx, sy});

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (outOfRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (!grid[nx][ny]) continue;

                visited[nx][ny] = true;
                que.add(new int[]{nx, ny});
            }
        }
    }

    static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

}

/*
       s >= n(n+1)/2
*/