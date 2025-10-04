
import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = new int[]{1, 0, -1, 0, 0, 0};
    static int[] dy = new int[]{0, 1, 0, -1, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, 1, -1};

    static int [][][] grid, dist;
    static int m,n,h;

    static class Pos{
        int x, y, z;

        public Pos(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        grid = new int[n][m][h];
        List<Pos> startList = new ArrayList<>();

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    grid[i][j][k] = Integer.parseInt(st.nextToken());
                    if (grid[i][j][k] == 1) startList.add(new Pos(i, j, k));
                }
            }
        }


        int[][][] result = bfs(startList);

        printAnswer(result);
    }
    static void printAnswer(int[][][] result){
        int answer = -1;

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (result[i][j][k] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, result[i][j][k]);
                }
            }
        }

        System.out.println(answer);
    }

    static int[][][] bfs(List<Pos> starts) {
        int [][][] dist= new int[n][m][h];
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j][k] == -1) dist[i][j][k] = 0;
                    else dist[i][j][k] = -1;
                }
            }
        }


        Queue<Pos> queue = new ArrayDeque<>();

        for (Pos start : starts) {
            dist[start.x][start.y][start.z] = 0;
            queue.add(start);
        }

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            int cx = cur.x;
            int cy = cur.y;
            int cz = cur.z;

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nz = cz + dz[i];

                if (outOfRange(nx,ny,nz)) continue;
                if (grid[nx][ny][nz] != 0) continue; // 익지않은 놈이 아니라면
                if (dist[nx][ny][nz] != -1) continue; // 방문한적있다면

                dist[nx][ny][nz] = dist[cx][cy][cz] + 1;
                queue.add(new Pos(nx, ny, nz));

            }
        }
        return dist;
    }

    static private boolean outOfRange(int x, int y, int z) {

        return x < 0 || x >= n || y < 0 || y >= m || z < 0 || z >= h;
    }
}

/*
정수 1은 익은 토마토
정수 0은 익지 않은 토마토
정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
* */
