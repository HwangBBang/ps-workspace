
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] grid;
    static int r, c;
    static final int INF = Integer.MAX_VALUE;
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] start = new int[2];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        List<int[]> fires = new ArrayList<>();
        grid = new char[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 1; j <= c; j++) {
                grid[i][j] = line[j-1];
                if (grid[i][j] == 'F') fires.add(new int[]{i, j});
                if (grid[i][j] == 'J') start = new int[]{i, j};
            }
        }

        int[][] isFire = moveFire(fires);
        int[][] result = moveMan(start, isFire);
        String answer = getAnswer(result);

        System.out.println(answer);
    }

    private static String getAnswer(int[][] result){
        int temp = INF;

        for (int i = 1; i <= r ; i++) { // |
            if (result[i][1] != -1) temp = Math.min(result[i][1], temp);
            if (result[i][c] != -1) temp = Math.min(result[i][c], temp);
        }
        for (int i = 1; i <= c ; i++) { // -
            if (result[1][i] != -1) temp = Math.min(result[1][i], temp);
            if (result[r][i] != -1) temp = Math.min(result[r][i], temp);
        }

        return temp == INF ? "IMPOSSIBLE" : String.valueOf(temp + 1);
    }

    private static int[][] moveFire(List<int[]> fires){
        int[][] isFire = new int[r + 1][c + 1];
        ArrayDeque<int[]> fireQue = new ArrayDeque<>();
        for (int i = 1; i <= r; i++) {
            Arrays.fill(isFire[i],INF);
        }

        for (int[] fire : fires) {
            isFire[fire[0]][fire[1]] = 0;
            fireQue.add(fire);
        }

        while (!fireQue.isEmpty()) {
            int[] cFire = fireQue.poll();
            int cx = cFire[0], cy = cFire[1];
            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (outOfRange(nx, ny)) continue;
                if (grid[nx][ny] == '#') continue;
                if (isFire[nx][ny] != INF) continue;

                isFire[nx][ny] = isFire[cx][cy] + 1;
                fireQue.add(new int[]{nx, ny});
            }
        }
        return isFire;
    }

    private static int[][] moveMan(int[] start, int[][] isFire) {
        int[][] dist = new int[r + 1][c + 1];
        ArrayDeque<int[]> humanQue = new ArrayDeque<>();
        for (int i = 0; i <= r; i++) Arrays.fill(dist[i], -1);

        dist[start[0]][start[1]] = 0;
        humanQue.add(start);

        while (!humanQue.isEmpty()) {
            int[] cur = humanQue.poll();
            int cx = cur[0], cy = cur[1];
            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i]; int ny = cy + dy[i];

                if (outOfRange(nx, ny)) continue;
                if (grid[nx][ny] == '#') continue;
                if (dist[nx][ny] != -1) continue;
                if (isFire[nx][ny] <= dist[cx][cy] + 1) continue;

                dist[nx][ny] = dist[cx][cy] + 1;
                humanQue.add(new int[]{nx, ny});
            }
        }
        return dist;
    }

    private static boolean outOfRange(int x, int y) {
        return x < 1 || x > r || y < 1 || y > c;
    }
}
