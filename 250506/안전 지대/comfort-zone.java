import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] grid;
    static boolean[][] visited;

    static int kMax = 0;
    static List<Household> group;
    static List<List<Household>> groups = new ArrayList<>();

    static class Household {
        int x;
        int y;

        public Household(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Answer {
        int k;
        int count;

        public Answer(int k, int count) {
            this.k = k;
            this.count = count;
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m];

//      k 의 따라 순회
//      k 이하 인것들 0 으로 만들기 & 그룹 (DFS)
//      0이 아닌 것들 그룹 (DFS)
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int ii = 0; ii < m; ii++) {
                grid[i][ii] = Integer.parseInt(st.nextToken());
                kMax = Math.max(kMax, grid[i][ii]);
            }
        }

        Answer answer = new Answer(0, -1);

        for (int k = 1; k <= kMax; k++) {

            visited = new boolean[n][m];
            Answer result = getSafeZoneCount(k);
            if (answer.count < result.count) {
                answer.count = result.count;
                answer.k = k;
            }
        }

        System.out.println(answer.k + " " + answer.count);

    }

    static Answer getSafeZoneCount(int k) {
        groups = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int ii = 0; ii < m; ii++) {
                if (!visited[i][ii] && grid[i][ii] > k) {
                    group = new ArrayList<>();

                    visited[i][ii] = true;
                    group.add(new Household(i, ii));

                    dfsForCount(i, ii, k);
                    groups.add(group);
                }
            }
        }
        return new Answer(k, groups.size());
    }

    static void dfsForCount(int x, int y, int k) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isNotRange(nx, ny)) continue;
            if (visited[nx][ny]) continue;
            if (grid[nx][ny] <= k) continue;

            visited[nx][ny] = true;
            group.add(new Household(nx, ny));
            dfsForCount(nx, ny, k);

        }

    }

    static boolean isNotRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}
