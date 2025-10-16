
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Pos {
        int x, y;
        public Pos(int x, int y){
            this.x = x; this.y = y;
        }
    }

    public static class Command{
        final int dIdx;
        final int s;

        public Command(int dIdx, int s) {
            this.dIdx = dIdx;
            this.s = s;
        }

        public Pos shiftPos(Pos pos) {
            int nx = pos.x + dx[this.dIdx] * this.s;
            int ny = pos.y + dy[this.dIdx] * this.s;

            return new Pos(calculatePos(nx), calculatePos(ny));
        }

        public void rain(List<Pos> nextCloud){
            for (Pos pos : nextCloud) grid[pos.x][pos.y]++;
        }

        public void magic(List<Pos> nextCloud) {
            // BOJ 21610 규칙: 대각선 네 칸(↖, ↗, ↘, ↙)만 확인
            for (Pos pos : nextCloud) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = pos.x + ddx[k];
                    int ny = pos.y + ddy[k];
                    // 범위 밖은 무시 (래핑 금지)
                    if (nx < 1 || nx > n || ny < 1 || ny > n) continue;
                    if (grid[nx][ny] > 0) cnt++;
                }
                grid[pos.x][pos.y] += cnt; // 이웃 수만큼 현재 칸 물 증가
            }
        }

        public List<Pos> createCloud(boolean[][] wasCloud) {
            List<Pos> newCloud = new ArrayList<>();
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n; j++) {
                    if (grid[i][j] < 2) continue;
                    if (wasCloud[i][j]) continue;
                    grid[i][j] -= 2;
                    newCloud.add(new Pos(i, j));
                }
            }
            return newCloud;
        }
        //                                      2      4     6     8
        static final int[] dx = new int[]{0, 0, -1, -1, -1, 0, 1, 1, 1};
        static final int[] dy = new int[]{0, -1, -1, 0, 1, 1, 1, 0, -1};
        static final int[] ddx = new int[]{-1, -1, 1, 1};
        static final int[] ddy = new int[]{-1,  1, 1,-1};
    }

    static int[][] grid;
    static int n;
    static List<Pos> clouds = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        grid = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clouds.add(new Pos(n, 1));
        clouds.add(new Pos(n, 2));
        clouds.add(new Pos(n - 1, 1));
        clouds.add(new Pos(n - 1, 2));

        Command[] cmds = new Command[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            cmds[i] = new Command(d, s);
        }
        for (int i = 0; i < m; i++) {
            simulation(cmds[i]);
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                answer += grid[i][j];
            }
        }
        System.out.println(answer);
    }

    private static void simulation(Command cur) {
        List<Pos> nextCloud = new ArrayList<>();
        for (Pos pos : clouds) nextCloud.add(cur.shiftPos(pos));

        cur.rain(nextCloud);

        cur.magic(nextCloud);

        boolean[][] wasCloud = new boolean[n + 1][n + 1];
        for (Pos pos : nextCloud) wasCloud[pos.x][pos.y] = true;

        clouds = cur.createCloud(wasCloud);
    }


    private static int calculatePos(int x) {
        return ((x - 1) % n + n) % n +1 ;
    }

    private static boolean outOfRange(int nx, int ny) {
        return nx < 1 || nx > n || ny < 1 || ny > n;
    }

}
//