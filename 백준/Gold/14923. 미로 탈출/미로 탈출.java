// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static final int INF = Integer.MAX_VALUE;
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};

    static int[][] grid;
    static int n, m;
    static int sx, sy;
    static int ex, ey;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        grid = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();
        int answer = result == INF ? -1 : result;

        System.out.println(answer);
    }

    static int bfs() {
        Queue<int[]> que = new ArrayDeque<>();
        int[][][] dist = new int[n + 1][m + 1][2]; //
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m ; j++) {
                Arrays.fill(dist[i][j], INF);
            }
        }

        dist[sx][sy][0] = 0;
        que.add(new int[]{sx, sy, 0});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];

            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];


                if (outOfRange(nx,ny)) continue;
                if (dist[nx][ny][cnt] != INF) continue;

                if (cnt >= 1) {
                    if (grid[nx][ny] == 1) continue;
                    // 벽 안 뚫기 (못 뚫어)
                    dist[nx][ny][cnt] = dist[cx][cy][cnt] + 1;
                    que.add(new int[]{nx, ny, cnt});

                } else{
                    if (grid[nx][ny] == 1) {// 벽이라면
                        dist[nx][ny][cnt + 1] = dist[cx][cy][cnt] + 1;
                        que.add(new int[]{nx, ny, cnt + 1});
                    } else { // 벽이 아니라면
                        dist[nx][ny][cnt] = dist[cx][cy][cnt] + 1;
                        que.add(new int[]{nx, ny, cnt});
                    }
                }
            }

        }

        return Math.min(dist[ex][ey][0], dist[ex][ey][1]);
    }
    static boolean outOfRange(int nx , int ny) {
        return nx < 1 || nx > n || ny < 1 || ny > m;
    }


}

/*
*/