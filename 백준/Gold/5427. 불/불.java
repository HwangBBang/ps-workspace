// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static final String IMPOSSIBLE = "IMPOSSIBLE";
    static final char WALL = '#';
    static final char FIRE = '*';
    static final char START = '@';
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};

    static StringBuilder sb;
    static int w, h;
    static char[][] grid;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            List<int[]> fires = new ArrayList<>();
            grid = new char[h + 1][w + 1];
            int[] start = new int[2];

            for (int i = 1; i <= h; i++) {
                char[] line = br.readLine().toCharArray();
                for (int j = 1; j <= w; j++) {
                    grid[i][j] = line[j - 1];

                    if (grid[i][j] == FIRE)
                        fires.add(new int[]{i, j});

                    else if (grid[i][j] == START) {
                        start[0] = i;
                        start[1] = j;
                    }
                }
            }
            simulations(start, fires);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void simulations(int[] start, List<int[]> fires) {

        int[][] fireLog = getFireLog(fires);
        int[][] dist = new int[h + 1][w + 1];
        for (int i = 0; i <= h; i++) Arrays.fill(dist[i], -1);
        Queue<int[]> que = new ArrayDeque<>();

        dist[start[0]][start[1]] = 0;
        que.add(start);

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int cx = cur[0], cy = cur[1];
            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (outOfRange(nx, ny)) { // 탈출
                    sb.append(dist[cx][cy] + 1);
                    return;
                }
                if (grid[nx][ny] == WALL) continue; // 벽임
                if (dist[nx][ny] != -1) continue; // 방문한적있음
                if (fireLog[nx][ny] <= dist[cx][cy] + 1) continue; // 불이 막는다면

                dist[nx][ny] = dist[cx][cy] + 1;
                que.add(new int[]{nx, ny});
            }
        }
        sb.append(IMPOSSIBLE);
    }

    static int[][] getFireLog(List<int[]> fires) {
        Queue<int[]> que = new ArrayDeque<>();
        int[][] fireLog = new int[h + 1][w + 1];
        for (int i = 0; i <= h; i++) Arrays.fill(fireLog[i], INF);

        for (int[] pos : fires) {
            fireLog[pos[0]][pos[1]] = 0;
            que.add(pos);
        }
        // 불
        while (!que.isEmpty()) {
            int[] curFire = que.poll();
            int cx = curFire[0], cy = curFire[1];
            for (int i = 0; i < dx.length; i++) {
                int nx = curFire[0] + dx[i];
                int ny = curFire[1] + dy[i];

                if (outOfRange(nx,ny)) continue;
                if (grid[nx][ny] == WALL) continue;
                if (fireLog[nx][ny] != INF) continue;

                fireLog[nx][ny] = fireLog[cx][cy] + 1;
                int[] nextFire = new int[]{nx, ny}; // 디버깅 후 인라인 최적화
                que.add(nextFire);

            }
        }
        return fireLog;
    }

    static boolean outOfRange(int x, int y) { // 탈출
        return x < 1 || x > h || y < 1 || y > w;
    }
}

// 불이 옮겨진 칸 또는 이제 불이 붙으려는 칸으로는 이동 불가
// 즉, 불 먼저 시뮬