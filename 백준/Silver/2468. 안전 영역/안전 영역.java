// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        grid = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for (int h = 0; h <= 100; h++) {
            answer = Math.max(answer, getResult(h));
        }
        System.out.println(answer);
    }

    static int getResult(int h) {
        visited = new boolean[n + 1][n + 1];
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (visited[i][j]) continue;
                if (grid[i][j] <= h) continue;
                bfs(i, j, h);
                result++;
            }
        }
        return result;
    }

    static void bfs(int sx, int sy, int h) {
        Queue<int[]> que = new ArrayDeque<>();
        visited[sx][sy] = true;
        que.add(new int[]{sx, sy});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (outOfRange(nx,ny)) continue;
                if (visited[nx][ny]) continue;
                if (grid[nx][ny] <= h) continue;

                visited[nx][ny] = true;
                que.add(new int[]{nx, ny});
            }
        }
    }

    static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }

}

/*
    높이 이하는 물에 다 잠긴다.
*/