
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int n, answer;
    static int[][] grid, dp;
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (dp[i][j] == 0) dfs(i, j);

                answer = Math.max(dp[i][j], answer);
            }
        }

        System.out.println(answer);
    }
    /*
        dp[x][y] 는 x,y 에서 시작해 최장 길이까지..
    */
    private static void dfs(int x, int y) {
        if (dp[x][y] != 0) return;
        dp[x][y] = 1;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (outOfRange(nx,ny)) continue;
            if (grid[x][y] >= grid[nx][ny]) continue;
            if (dp[nx][ny] == 0)
                dfs(nx, ny);
            dp[x][y] = Math.max(dp[x][y], dp[nx][ny] + 1);
        }
    }

    private static boolean outOfRange(int x, int y) {
        return 0 > x || n <= x || 0 > y || n <= y;
    }
}

/*

n × n의 크기의 대나무 숲이 있다.

욕심쟁이 판다는 어떤 지역에서 대나무를 먹기 시작한다.
그 곳의 대나무를 다 먹어 치우면 상, 하, 좌, 우 중 한 곳으로 이동을 한다.
또 그곳에서 대나무를 먹는다. 그런데 단 조건이 있다.

이 판다는 매우 욕심이 많아서 대나무를 먹고 자리를 옮기면,

그 옮긴 지역에 그 전 지역보다 대나무가 많이 있어야 한다.

이 판다의 사육사는 이런 판다를 대나무 숲에 풀어 놓아야 하는데,

어떤 지점에 처음에 풀어 놓아야 하고,

어떤 곳으로 이동을 시켜야 판다가 최대한 많은 칸을 방문할 수 있는지 고민에 빠져 있다.

우리의 임무는 이 사육사를 도와주는 것이다.

n × n 크기의 대나무 숲이 주어져 있을 때, 이 판다가 최대한 많은 칸을 이동하려면 어떤 경로를 통하여 움직여야 하는지 구하여라.

*/
