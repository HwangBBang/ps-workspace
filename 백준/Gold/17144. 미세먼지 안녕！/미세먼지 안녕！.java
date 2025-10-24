
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] grid , nextGrid;
    static List<Pair> cleanPos;
    //                      위 아래 오른 왼
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        grid = new int[R + 1][C + 1];
        nextGrid = new int[R + 1][C + 1];
        cleanPos = new ArrayList<>();

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == -1) {
                    cleanPos.add(new Pair(i, j));
                }
            }
        }
        int answer = simulation();
        System.out.println(answer);
    }

    private static int simulation() {
        int answer = 0;
        for (int i = 0; i < T; i++) {
            moveDust();// 먼지 이동
            work();// 공청 가동
        }
        for (int i = 1; i <= R ; i++) {
            for (int j = 1; j <= C; j++) {
                if (grid[i][j] <= 0) continue;
                answer += grid[i][j];
            }
        }
        return answer;
    }

    private static void work() {
        int left = 1, right = C;
        int top = 1, bottom = cleanPos.get(0).x;
        List<Integer> buffer = new ArrayList<>();
        // UpSide
        for (int y = left; y < right; y++) buffer.add(grid[bottom][y]);
        for (int x = bottom; x > top; x--) buffer.add(grid[x][right]);
        for (int y = right ; y > left; y--) buffer.add(grid[top][y]);
        for (int x = top; x < bottom; x++) buffer.add(grid[x][left]);

        int idx = 0, r = buffer.size();
        for (int y = left; y < right; y++) grid[bottom][y] = buffer.get(((idx++ - 1)+ r) % r);
        for (int x = bottom; x > top; x--) grid[x][right] = buffer.get(((idx++ - 1)+ r) % r);
        for (int y = right; y > left; y--) grid[top][y] = buffer.get(((idx++ - 1)+ r) % r);
        for (int x = top; x < bottom; x++) grid[x][left] = buffer.get(((idx++ - 1)+ r) % r);
        buffer.clear();
        grid[bottom][left] = -1;
        grid[bottom][left+1] = 0;

        // DownSide
        top = cleanPos.get(1).x; bottom = R;
        for (int y = left; y < right; y++) buffer.add(grid[top][y]);
        for (int x = top; x < bottom; x++) buffer.add(grid[x][right]);
        for (int y = right; y > left; y--) buffer.add(grid[bottom][y]);
        for (int x = bottom; x > top; x--) buffer.add(grid[x][left]);

        idx = 0; r = buffer.size();
        for (int y = left; y < right; y++) grid[top][y] = buffer.get(((idx++ - 1)+ r) % r);
        for (int x = top; x < bottom; x++) grid[x][right] = buffer.get(((idx++ - 1)+ r) % r);
        for (int y = right; y > left; y--) grid[bottom][y] = buffer.get(((idx++ - 1)+ r) % r);
        for (int x = bottom; x > top; x--) grid[x][left] = buffer.get(((idx++ - 1)+ r) % r);

        grid[top][left] = -1;
        grid[top][left+1] = 0;
    }




    private static void moveDust() {
        nextGrid = new int[R + 1][C + 1];
        // 공기청정기 고정
        for (Pair p : cleanPos) nextGrid[p.x][p.y] = -1;

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                int amount = grid[i][j];
                if (amount <= 0) continue;

                int curAmount = grid[i][j];
                if (curAmount / 5 == 0) {
                    nextGrid[i][j] += curAmount;
                    continue;
                }

                int cnt = 0;
                for (int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (outOfRange(nx, ny)) continue;
                    if (grid[nx][ny] == -1) continue;
                    cnt ++;
                    nextGrid[nx][ny] += curAmount / 5;
                }
                nextGrid[i][j] += curAmount - (cnt * (curAmount / 5));
            }
        }
        grid = nextGrid;
    }

    private static boolean outOfRange(int x, int y) {
        return x < 1 || x > R || y < 1 || y > C;
    }

}
/*
T는 경과 시간
-1 은 공기청정기
미세먼지 이동시키기

*/
