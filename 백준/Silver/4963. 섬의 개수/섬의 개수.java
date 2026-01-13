// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] grid;
    static boolean[][] visited;

    static final int[] dx = new int[]{0, 1, 0, -1, 1, 1, -1, -1};
    static final int[] dy = new int[]{1, 0, -1, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();



        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            grid = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (grid[i][j] == 0) continue;
                    if (visited[i][j]) continue;
                    bfs(i, j);
                    result++;
                }
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int d = 0; d < dx.length; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (outOfRange(nx,ny)) continue;
                if (grid[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                que.add(new int[]{nx, ny});
            }
        }
    }

    static boolean outOfRange(int x, int y) {
        return x < 0 || x >= h || y < 0 || y >= w;
    }

}

/*

*/