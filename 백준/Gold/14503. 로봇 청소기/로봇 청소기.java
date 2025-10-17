
import java.io.*;
import java.util.*;

public class Main {
    // 북 동 남 서
    static final int[] dx = new int[]{-1, 0, 1, 0};
    static final int[] dy = new int[]{ 0, 1, 0, -1};
    static int n,m, answer;
    static int[][] grid;
    static boolean[][] isCleanUp;
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        isCleanUp = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        simulation(sx,sy,d);
        System.out.println(answer);
    }
    private static void simulation(int sx, int sy, int d){
        while (true){
            // 1. 현재칸 검사
            if (!isCleanUp[sx][sy]){
                isCleanUp[sx][sy] = true;
                answer++;
            }

            // 2.
            if (!isExist(sx, sy)) {
                // 주변 청소칸 존재 X
                int nx = sx - dx[d]; // 후진
                int ny = sy - dy[d]; // 후진
                if (outOfRange(nx, ny) || grid[nx][ny] == 1) break;

                sx = nx; sy = ny;
            } else {
                // 주변 청소칸 존재 O
                d = ((d - 1) + dx.length) % dx.length; // 반시계 회전
                int nx = sx + dx[d]; // 전진
                int ny = sy + dy[d]; // 전진
                if (grid[nx][ny] == 0 && !isCleanUp[nx][ny]){
                    sx = nx; sy = ny;
                }
            }
        }
        
    }
    private static boolean isExist(int x , int y){
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i]; int ny = y + dy[i];
            if (outOfRange(nx,ny)) continue;
            if (grid[nx][ny] == 0 && !isCleanUp[nx][ny]) return true;
        }
        return false;
    }
    private static boolean outOfRange(int x, int y) {
        return 0 > x || x >= n || 0 > y || y >= m;
    }
}

/*
칸은 벽 또는 빈 칸
값이 0인 경우 => (i, j)가 청소되지 않은 빈 칸이고,
1인 경우 => (i, j)에 벽이 있는 것이다.

1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
2. 현재 칸의 주변  4칸 중 청소되지 않은 빈 칸이 없는 경우,
    1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
    2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
    1. 반시계 방향으로  90도 회전한다.
    2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
    3. 1번으로 돌아간다.
*/
