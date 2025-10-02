import java.io.*;
import java.util.*;

public class Main {

    static class Pos{
        int x,y;
        int use;
        int toggle;

        public Pos(int x, int y, int use, int toggle) {
            this.x = x;
            this.y = y;
            this.use = use;
            this.toggle = toggle;
        }
    }

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static int n, m, k;
    static boolean[][] isWall;
    static int[][][] dist;
    static final int NOT = -1;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        isWall = new boolean[n + 1][m + 1];
        dist = new int[n + 1][m + 1][(k + 1) * 2]; // 미방문 -1

        for (int i = 1; i <= n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                isWall[i][j] = (chars[j-1] == '1');
            }
        }

        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= m; j++) {
                Arrays.fill(dist[i][j], NOT);
            }
        }

        bfs(new Pos(1, 1, 0, 0));

        int answer = Integer.MAX_VALUE;
        for (int used = 0; used <=k ; used++) {
            for (int toggle = 0; toggle < 2; toggle++) {
                int candidate = dist[n][m][getStateIdx(used, toggle)];
                if (candidate != NOT) answer = Math.min(answer, candidate);
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        
    }

    static void bfs(Pos start){

        Queue<Pos> queue = new ArrayDeque<>();
        dist[start.x][start.y][getStateIdx(start.use, start.toggle)] = 1;
        queue.add(start);

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            int cx = cur.x, cy = cur.y, cu = cur.use, ct = cur.toggle;

            int cs = getStateIdx(cu, ct);

            if (cx == n && cy == m) return;

            int nt = ct ^ 1;
            for (int i = 0; i < dx.length; i++) {
                int nx  = cx + dx[i];
                int ny  = cy + dy[i];
                int nu = cu;

                if (outOfRange(nx,ny)) continue;
                if (!isWall[nx][ny]){ // 빈칸이라면
                    int ns = getStateIdx(nu, nt);

                    if (dist[nx][ny][ns] != NOT) continue; // 방문 했다면
                    dist[nx][ny][ns] = dist[cx][cy][cs] + 1;
                    queue.add(new Pos(nx, ny, nu, nt));
                }
                else{ // 벽이라면
                    if (ct == 1) continue; // 현재 밤이라면
                    if (cu >= k) continue; // 벽 부시기를 모두 소모했다면

                    nu = cu + 1; // 깨부신 횟수 업데이트
                    int ns = getStateIdx(nu, nt);
                    if (dist[nx][ny][ns] != NOT) continue; // 방문 했다면

                    dist[nx][ny][ns] = dist[cx][cy][cs] + 1;
                    queue.add(new Pos(nx, ny, nu, nt));
                }
            }

            if (ct == 1){
                int waitIdx = getStateIdx(cu, nt);
                if (dist[cx][cy][waitIdx] == NOT) {
                    dist[cx][cy][waitIdx] = dist[cx][cy][cs] + 1; // 시간 +1
                    queue.add(new Pos(cx, cy, cu, nt));
                }
            }

        }
    }

    static private boolean outOfRange(int nx, int ny){
        return nx < 1 || nx > n || ny < 1 || ny > m;
    }

    static private int getStateIdx (int s, int toggle) {
        return s*2 + toggle;
    }
}
