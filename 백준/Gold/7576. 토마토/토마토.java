
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int [][] grid, dist;
    static int m;
    static int n;

    static class Pos{
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        List<Pos> startList = new ArrayList<>();
        int tomatoCnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) startList.add(new Pos(i,j));
                if (grid[i][j] == -1) continue;
                tomatoCnt ++;
            }
        }
        int answer = -1 ;
        int answerCnt = 0;
        int[][]result = bfs(startList);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] != -1) answerCnt++;
                answer= Math.max(answer, result[i][j]);
            }

        }
        System.out.println(answerCnt == tomatoCnt ? answer : -1);
    }

    static int[][] bfs(List<Pos> starts) {
        int [][] dist= new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        Queue<Pos> queue = new ArrayDeque<>();

        for (Pos start : starts) {
            dist[start.x][start.y] = 0;
            queue.add(start);
        }

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (outOfRange(nx,ny)) continue;
                if (grid[nx][ny] == 1 || grid[nx][ny] == -1) continue; // 비어있거나, 익은놈
                if (dist[nx][ny] >= dist[cx][cy] || dist[nx][ny] > 0) continue; // 방문한적있다면

                dist[nx][ny] = dist[cx][cy] + 1;
                queue.add(new Pos(nx,ny));

            }
        }
        return dist;
    }

    static private boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}

/*
정수 1은 익은 토마토
정수 0은 익지 않은 토마토
정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
* */