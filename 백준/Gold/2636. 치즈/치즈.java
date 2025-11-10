// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m;
    static final String CHEESE = "1";
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};

    static boolean[][] grid;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int total = 0, time = 0, removedCnt = 0;

        grid = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                if (st.nextToken().equals(CHEESE)){
                    grid[i][j] = true;
                    total ++;
                }
            }
        }

        while (total != 0) {
            removedCnt = removeCheese(grid);
            total -= removedCnt;
            time ++;
        }
        System.out.println(time);
        System.out.println(removedCnt);

    }
    private static int removeCheese(boolean[][] isCheese){
        Queue<int[]> deq = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!isCheese[i][j]) continue;
                if (!isNearAir(i, j, isCheese)) continue;
                // 여기 까지 왔다면, 치즈이면서, 공기와 맞닿아있음

                if (isExpose(i, j, isCheese)) {
                    deq.add(new int[]{i, j});// 제거 대상에 추가
                }
            }
        }
        // 이제 제거대상을 제거한 다음 grid를 생성
        boolean[][] nextIsCheese = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            System.arraycopy(isCheese[i], 0, nextIsCheese[i], 0, m + 1);
        }
        int cnt = 0;
        while (!deq.isEmpty()) {
            int[] cur = deq.poll();
            int targetX = cur[0];
            int targetY = cur[1];
            nextIsCheese[targetX][targetY] = false;
            cnt ++;
        }

        grid = nextIsCheese;
        return cnt;
    }

    private static boolean isNearAir(int x, int y, boolean[][] isCheese) {
        for (int k = 0; k < dx.length; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (outOfRange(nx, ny)) continue;
            if (!isCheese[nx][ny]) return true;
        }
        return false;
    }
    private static boolean isExpose(int x, int y,  boolean[][] isCheese) {
        boolean[][] visited = new boolean[n + 1][m + 1];
        Queue<int[]> que = new ArrayDeque<>();
        visited[x][y] = true;
        que.add(new int[]{x, y});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];

            if (cx == 1 || cy == 1 || cx == n || cy == m) return true;

            for (int k = 0; k < dx.length; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if (outOfRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (isCheese[nx][ny]) continue;
                visited[nx][ny] = true;
                que.add(new int[]{nx, ny});
            }
        }

        return false;
    }
    private static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > m;
    }
}
/*
    100 x 100

    노출이 되어있다면 사라질 예정
    현재 치즈 갯수를 저장
    다음 치즈 상태는 nextGrid로 원본을 직접 변경하지않는 방향으로
    그럼 노출이 되어있는지 어떻게 확인하지 ?
    노출의 기준
    0. 치즈여야한다.
    1. 치즈가 없는 상태와 (공기) 맞닿아있다. (이웃을 확인하며 치즈가 치즈가 아닌 녀석이있는지 확인)
    2. 가장 밖의 치즈여야한다. .? BFS 돌면서 X 친 범위에 도달한다면, 밖의 치즈임
    => 두 조건 모두 만족한다면, 제거 대상


    0 0 0 0 0 0 0 0
    0 1 0 1 1 1 1 0
    0 1 0 0 0 0 1 0
    0 1 0 1 1 0 1 0
    0 1 0 0 0 0 1 0
    0 1 1 1 1 1 1 0
    0 0 0 0 0 0 0 0

    0 1 0  |  1 0 1
    1 0 1  |  0 0 0
    0 1 0  |  1 0 1

    0 0 1 1 0
    0 1 1 0 1
    1 0 1 0 1
    0 1 1 1 0


*/

