import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static List<Position> group;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        visited = new boolean[n][n];

//      k 의 따라 순회
//      k 이하 인것들 0 으로 만들기 & 그룹 (DFS)
//      0이 아닌 것들 그룹 (DFS)
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int ii = 0; ii < n; ii++) {
                grid[i][ii] = Integer.parseInt(st.nextToken());
            }
        }

        int poped = 0, maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int ii = 0; ii < n; ii++) {
                if (!visited[i][ii]) {
                    group = new ArrayList<>();

                    visited[i][ii] = true;
                    group.add(new Position(i, ii));

                    dfs(i, ii, grid[i][ii]);

                    maxSize = Math.max(maxSize, group.size());
                    if (group.size() >= 4) {
                        poped++;
                    }
                }
            }
        }
        System.out.println(poped + " " + maxSize);

    }

    static void dfs(int x, int y, int pivot) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isNotRange(nx, ny)) continue;
            if (visited[nx][ny]) continue;
            if (grid[nx][ny] != pivot) continue;

            visited[nx][ny] = true;
            group.add(new Position(nx, ny));
            dfs(nx, ny, pivot);
        }

    }

    static boolean isNotRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }

}
