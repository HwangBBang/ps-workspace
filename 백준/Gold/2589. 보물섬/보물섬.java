// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n,m;
    static char[][] grid;
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line[j];
            }
        }
        int answer = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 'L') continue;
                answer = Math.max(answer, bfs(i, j));
            }
        }
        System.out.println(answer);

    }

    static int bfs(int sx, int sy) {
        int result = -1;

        Queue<int[]> que = new ArrayDeque<>();
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        dist[sx][sy] = 0;
        que.add(new int[]{sx, sy});

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int d = 0; d < dx.length; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (outOfRange(nx,ny)) continue;
                if (grid[nx][ny] != 'L') continue;
                if (dist[nx][ny] != -1) continue;


                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                que.add(new int[]{nx, ny});
                result = Math.max(result, dist[nx][ny]);
            }
        }
        return result;
    }

    static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

}

// bfs 반복
// 플로이드 워셜