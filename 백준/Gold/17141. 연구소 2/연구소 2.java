
import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer;
    static int[][] grid;

    static List<int[]> candidates;
    static List<int[]> selected;
    static final int INF = Integer.MAX_VALUE / 4;
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n + 1][n + 1];
        candidates = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 2) candidates.add(new int[]{i, j});
            }
        }
        answer = INF;
        selected = new ArrayList<>();
        choice(0, 0);

        answer = answer == INF ? -1 : answer;
        System.out.println(answer);
    }

    public static int simulation() {
//        selected 에서 시작된다 바이러스가.
        int time = 0;
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[n + 1][n + 1];
        int[][] timeTable = new int[n + 1][n + 1];
        for (int i = 1; i < n+1; i++) {
            Arrays.fill(timeTable[i], -1);
        }
        for (int[] s : selected) {
            visited[s[0]][s[1]] = true;
            timeTable[s[0]][s[1]] = 0;
            que.add(s);
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int curTime = timeTable[cur[0]][cur[1]];

            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (outOfRange(nx,ny)) continue;
                if (visited[nx][ny]) continue;
                if (grid[nx][ny] == 1) continue;
                if (timeTable[nx][ny] != -1) continue;

                visited[nx][ny] = true;
                timeTable[nx][ny] = curTime + 1;
                time = Math.max(time, timeTable[nx][ny]);
                que.add(new int[]{nx, ny});
            }
        }
        time = isComplete(timeTable) ? time : INF;
        return time;
    }

    private static boolean isComplete(int[][] timeTable) {
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i][j] != 1 && timeTable[i][j] == -1) return false;
            }
        }
        return true;
    }
    private static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }

    public static void choice(int start, int cnt) {
        if (cnt == m) {
            int result = simulation();
            answer = Math.min(answer,result);
//            System.out.println(answer);
            return;
        }
        for (int i = start; i < candidates.size(); i++) {
            selected.add(candidates.get(i));
            choice(i + 1, cnt + 1);
            selected.remove(selected.size() - 1);
        }
    }
}
