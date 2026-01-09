// package baekjoon.gold;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, d;
    static int answer = -1;
    static int[][] grid, map;
    static int[] defenseLine;

    static final int[] dx = new int[]{0, -1, 0};
    static final int[] dy = new int[]{-1, 0, 1};

    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n + 2][m + 1];
        defenseLine = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(1,0);
        System.out.println(answer);
    }

    private static void backtracking(int start, int step) {
        if (step == 3) {
            int result = simulation(defenseLine);
            answer = Math.max(answer, result);
            return;
        }

        for (int i = start; i <= m; i++) {
            defenseLine[i] = 2;
            setGrid(map);
            backtracking(i + 1, step + 1);
            defenseLine[i] = 0;
        }
    }

    private static void setGrid(int[][] map) {
        grid = new int[n + 2][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                grid[i][j] = map[i][j];
            }
        }
    }
    private static int simulation(int[] defenseLine) {
        int result = 0;
        // 궁수 배치
        for (int i = 1; i <= m ; i++) {
            grid[n + 1][i] = defenseLine[i];
        }
        while (!isFinish()) {
            // 궁수 공격
            result += attack();
            // 적의 이동
            moveEnemy();
        }

        return result;
    }

    private static int attack() {
        int result = 0;
        List<int[]> attackedEnemy = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            if (grid[n + 1][i] == 2) {
                int[] attacked = bfs(new int[]{n + 1, i});
                if (attacked == null) continue;
                attackedEnemy.add(attacked);
            }
        }

        for (int[] enemy : attackedEnemy) {
            int x = enemy[0], y = enemy[1];
            if (grid[x][y] != 1) continue;
            grid[x][y] = 0;
            result++;
        }

        return result;
    }

    private static int[] bfs(int[] start) {
        Queue<int[]> que = new ArrayDeque<>();
        int[][] dist = new int[n + 2][m + 1];
        for (int i = 1; i <= n+1; i++) {
            Arrays.fill(dist[i], -1);
        }

        dist[start[0]][start[1]] = 0;
        que.add(start);

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (grid[cur[0]][cur[1]] == 1) return cur;

            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (outOfRange(nx, ny)) continue;
                if (dist[nx][ny] != -1) continue;
                if (dist[cur[0]][cur[1]] + 1 > d) continue;

                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                que.add(new int[]{nx, ny});
            }
        }
        return null;
    }

    private static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > m;
    }

    private static boolean isFinish() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (grid[i][j] == 1) return false;
            }
        }
        return true;
    }

    private static void moveEnemy() {
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                if (j + 1 > n) continue;
                grid[j + 1][i] = grid[j][i];
            }
        }
        for (int i = 1; i <= m; i++) {
            grid[1][i] = 0;
        }
    }

    private static int getDist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

}

/*
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
1 1 1 1 1
성 성 성 성 성

1 : 적
2 : 궁수

캐슬 디펜스는 성을 향해 몰려오는 적을 잡는 턴 방식의 게임이다.
게임이 진행되는 곳은 크기가 N×M인 격자판으로 나타낼 수 있다. 격자판은 1×1 크기의 칸으로 나누어져 있고, 각 칸에 포함된 적의 수는 최대 하나이다.
격자판의 N번행의 바로 아래(N+1번 행)의 모든 칸에는 성이 있다.

성을 적에게서 지키기 위해 궁수 3명을 배치하려고 한다. 궁수는 성이 있는 칸에 배치할 수 있고, 하나의 칸에는 최대 1명의 궁수만 있을 수 있다.

각각의 턴마다 궁수는 적 하나를 공격할 수 있고, 모든 궁수는 동시에 공격한다.

궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적이고,
그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격한다.
같은 적이 여러 궁수에게 공격당할 수 있다.
공격받은 적은 게임에서 제외된다.
-> BFS 로 처리

궁수의 공격이 끝나면, 적이 이동한다. 적은 아래로 한 칸 이동하며, 성이 있는 칸으로 이동한 경우에는 게임에서 제외된다.
모든 적이 격자판에서 제외되면 게임이 끝난다.

게임 설명에서 보다시피 궁수를 배치한 이후의 게임 진행은 정해져있다.
따라서, 이 게임은 궁수의 위치가 중요하다.
격자판의 상태가 주어졌을 때, 궁수의 공격으로 제거할 수 있는 적의 최대 수를 계산해보자.

-> 결국 여러개 다해봐야하는것 같음 백트랙킹
뭐에 대해서? 궁수의 위치 조합
*/
