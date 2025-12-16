// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int n, m;

    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean[][] grid = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                grid[i][j] = (Integer.parseInt(st.nextToken()) == 1);
            }
        }

        visited = new boolean[n + 1][m + 1];
        int cntAnswer = 0;
        int areaAnswer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (visited[i][j]) continue;
                if (!grid[i][j]) continue;
                areaAnswer = Math.max(areaAnswer, bfs(i, j, grid));
                cntAnswer++;
            }
        }
        System.out.println(cntAnswer);
        System.out.println(areaAnswer);

    }

    static int bfs(int x, int y, boolean[][] grid) {
        int result = 0; // 면적 계산.
        Queue<int[]> que = new ArrayDeque<>();

        visited[x][y] = true;
        result++;
        que.add(new int[]{x, y});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (outOfRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (!grid[nx][ny]) continue;

                visited[nx][ny] = true;
                result++;
                que.add(new int[]{nx, ny});
            }
        }

        return result;
    }

    static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > m;
    }

}
