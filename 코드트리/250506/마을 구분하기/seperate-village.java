import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static List<Household> group;
    static List<List<Household>> groups = new ArrayList<>();

    static class Household{
        int x;
        int y;

        public Household(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int ii = 0; ii < n; ii++) {
                grid[i][ii] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int ii = 0; ii < n; ii++) {
                if (!visited[i][ii] && grid[i][ii] == 1) {
                    visited[i][ii] = true;
                    group = new ArrayList<>();
                    group.add(new Household(i, ii));
                    dfs(i, ii);
                    groups.add(group);
                }
            }
        }

        printAnswer();

    }

    static void dfs(int x, int y) {
//      종료 조건
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isNotRange(nx, ny)) continue;
            if (visited[nx][ny]) continue;
            if (grid[nx][ny] == 0) continue;

            visited[nx][ny] = true;
            group.add(new Household(nx, ny));
            dfs(nx, ny);
        }
    }
    static boolean isNotRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }

    static void printAnswer() {
        int len = groups.size();
        System.out.println(len);

        List<Integer> ans = new ArrayList<>();
//        groups 의 group 의 갯수들(int)을 추출하여 answer로 만들어 정렬해서 출력
        
        for (List<Household> households : groups) {
            ans.add(households.size());
        }

        Collections.sort(ans);

        for (Integer an : ans) {
            System.out.println(an);
        }
    }
}
