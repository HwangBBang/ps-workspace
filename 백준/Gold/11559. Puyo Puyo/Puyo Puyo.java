
import java.io.*;
import java.util.*;

public class Main {
    static final int r = 12, c = 6;
    static final int DOWN = 1;
    static char[][] grid;
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        grid = new char[r][c];

        for (int i = 0; i < r; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                grid[i][j] = chars[j];
            }
        }

        int answer = simulation();
        System.out.println(answer);
    }

    private static int simulation() {
        int cnt = 0;
        while (pop() != 0) {
            cnt ++;
            down();
        }
        return cnt;
    }

    private static int pop() {
        int cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '.') continue;
                char pivot = grid[i][j];
                cnt += bfs(i, j, pivot);
            }
        }
        return cnt;
    }
    private static int bfs(int x, int y, char p) {
        boolean[][] visit = new boolean[r][c];
        Queue<int[]> que = new ArrayDeque<>();
        List<int[]> group = new ArrayList<>();

        int[] start = new int[]{x, y};
        visit[x][y] = true;
        que.add(start);group.add(start);

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0], cy = cur[1];
            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i]; int ny = cy + dy[i];

                if (outOfRange(nx,ny)) continue;
                if (grid[nx][ny] != p) continue;
                if (visit[nx][ny]) continue;

                visit[nx][ny] = true;
                int[] next = new int[]{nx, ny};
                que.add(next); group.add(next);
            }
        }
        int result = 0;

        if (group.size() < 4) return result;
        for (int[] each : group) {
            int popX = each[0], popY = each[1];
            grid[popX][popY] = '.';
            result++;
        }
        return result;
    }

    private static void down() {
        for (int j = 0; j < c; j++) {
            vertaxOneLine(j);
        }
    }
    private static void vertaxOneLine(int y){
        for (int x = r - 1; x >= 0; x--) {
            if (grid[x][y] == '.') continue;
            while (true){
                int nx = x + dx[DOWN];
                int ny = y + dy[DOWN];
                if (outOfRange(nx, ny)) break;
                if (grid[nx][ny] != '.') break;
                swap(x, y, nx, ny);
                x = nx;
            }

        }
    }
    private static void swap(int x, int y, int nx, int ny) {
        char tmp = grid[nx][ny];
        grid[nx][ny] = grid[x][y];
        grid[x][y] = tmp;
    }
    private static boolean outOfRange(int x, int y) {
        return x < 0 || x >= r || y < 0 || y >= c;
    }


}
/*

    1. 뿌요는 중력의 영향을 받아 아래에 바닥이나 다른 뿌요가 나올 때까지 아래로 떨어진다.
    2.  같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 한꺼번에 없어진다. 이때 1연쇄가 시작된다.
    3. 역시 중력의 영향을 받아 차례대로 아래로 떨어지게 된다.


    ......
    ......
    R.....
    ......
    .Y....
    .YG...
    .RYG..
    RRYGG.
*/