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
    static int[] dx = new int[]{0, 1, 0, -1, 0, 0};
    static int[] dy = new int[]{1, 0, -1, 0, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, -1, 1};
    static int l, r, c;

    static final int INF = Integer.MAX_VALUE;
    static char[][][] grid;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) break;

            grid = new char[l][r][c];
            int[] start = new int[3]; // l,r,c
            int[] end = new int[3];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    char[] line = br.readLine().toCharArray();
                    for (int k = 0; k < c; k++) {
                        grid[i][j][k] = line[k];
                        if (grid[i][j][k] == 'S') {
                            start = new int[]{i, j, k};
                        } else if (grid[i][j][k] == 'E') {
                            end = new int[]{i, j, k};
                        }
                    }
                }
                br.readLine();
            }
            int result = simulation(start, end);
            sb.append(result == INF ? "Trapped!\n" : String.format("Escaped in %d minute(s).\n", result));
        }


        System.out.println(sb);
    }


    private static int simulation(int[] start, int[] end) {
        Queue<int[]> que = new ArrayDeque<>();
        int[][][] dist = new int[l][r][c];

        for (int i = 0; i < l; i++)
            for (int j = 0; j < r; j++)
                Arrays.fill(dist[i][j], INF);



        dist[start[0]][start[1]][start[2]] = 0;
        que.add(start);

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dx.length; i++) {
                int cx = cur[0], cy = cur[1], cz = cur[2];
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nz = cz + dz[i];

                if (outOfRange(nx, ny ,nz)) continue;
                if (grid[nx][ny][nz] == '#') continue;
                if (dist[nx][ny][nz] != INF) continue;

                dist[nx][ny][nz] = dist[cx][cy][cz] + 1;
                que.add(new int[]{nx, ny, nz});
            }
        }
        return dist[end[0]][end[1]][end[2]];
    }
    private static boolean outOfRange(int x, int y, int z) {
        return 0 > x || l <= x || 0 > y || r <= y || 0 > z || c <= z;
    }
}

/*


*/
