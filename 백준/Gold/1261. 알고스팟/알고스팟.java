
import java.io.*;
import java.util.*;


public class Main {
    static class Pair implements Comparable<Pair>{
        int x, y, cnt;

        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.cnt, other.cnt);
        }
    }

    static int n, m;
    static final int INF = Integer.MAX_VALUE;
    static boolean[][] isWall;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        isWall = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                if (line[j - 1] == '0') continue;
                isWall[i][j] = true;
            }
        }

        int answer = solution(new Pair(1, 1, 0));
        System.out.println(answer);
    }

    static int solution(Pair start) {
        int[][] use = new int[n + 1][m + 1];
        Queue<Pair> que = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) Arrays.fill(use[i], INF);

        use[start.x][start.y] = 0;
        que.add(start);

        while (!que.isEmpty()) {
            Pair cur = que.poll();
            if (use[cur.x][cur.y] != cur.cnt) continue;

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (outOfRange(nx,ny)) continue;
                int tmp = isWall[nx][ny] ? 1 : 0;
                if (cur.cnt + tmp < use[nx][ny]) {
                    use[nx][ny] = cur.cnt + tmp;
                    que.add(new Pair(nx, ny, use[nx][ny]));
                }
            }
        }
        return use[n][m];
    }

    static boolean outOfRange(int x, int y) {
        return 1 > x || n < x || 1 > y || m < y;
    }
}
