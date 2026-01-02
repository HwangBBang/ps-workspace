// package baekjoon.silver;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] dy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int result = bfs(sx, sy, ex, ey, n);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int sx, int sy,
                    int ex, int ey, int n) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        Queue<int[]> que = new ArrayDeque<>();

        dist[sx][sy] = 0;
        que.add(new int[]{sx, sy});
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (cur[0] == ex && cur[1] == ey) break;
            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (outOfRange(nx, ny, n)) continue;
                if (dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                que.add(new int[]{nx, ny});
            }
        }
        return dist[ex][ey];
    }

    static boolean outOfRange(int x, int y, int n) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }

}

/*

*/