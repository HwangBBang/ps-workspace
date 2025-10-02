
import java.io.*;
import java.util.*;

public class Main {

    static class Pos{
        int x,y;
        int s;

        public Pos(int x, int y, int s) {
            this.x = x;
            this.y = y;
            this.s = s;
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

        isWall = new boolean[n+1][m+1];
        dist = new int[n+1][m+1][k+1]; // 미방문 -1

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

        bfs(new Pos(1,1,0));

        int answer = -1;
        for (int candidate : dist[n][m]) {
            answer = Math.max(answer, candidate);
        }

        System.out.println(answer);
    }

    static void bfs(Pos start){
        Queue<Pos> queue = new ArrayDeque<>();
        // 시작점 세팅
        queue.add(start);
        dist[start.x][start.y][start.s] = 1;

        while (!queue.isEmpty()){
            Pos cur = queue.poll();
            int cx = cur.x;
            int cy = cur.y;
            int cs = cur.s;

            if (cx == n && cy == m) return;

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int ns = cs;

                if (outOfRange(nx,ny)) continue;

                if (!isWall[nx][ny]) { // 빈칸이라면
                    if (dist[nx][ny][ns] != NOT) continue; // 미방문인지?

                    dist[nx][ny][ns] = dist[cx][cy][cs] + 1;
                    queue.add(new Pos(nx, ny, ns));
                } else { // 벽이라면
                    if (cs >= k) continue; // 부실 수 없음
                    // 부실 수 있음
                    ns = cs + 1;

                    if (dist[nx][ny][ns] != NOT) continue; // 미방문인지?

                    dist[nx][ny][ns] = dist[cx][cy][cs] + 1;
                    queue.add(new Pos(nx, ny, ns));
                }

            }

        }
    }

    static private boolean outOfRange(int nx, int ny){
        return nx < 1 || nx > n || ny < 1 || ny > m;
    }
}

// 격자 1_000_000
// 최단 경로접근이니, 우선은 bfs 를 활용하자. 가중치 X
// 1-base isWall

// 정점에 대한 메모리는 1_000 * 1_000 * 10 (상태 수)
// 전이 규칙.

/*
    벽이아니라면 -> 기존 처럼
    벽이라면,
        더이상 뿌실 수 없다면, continue;
        뿌실 수 있다면, 뿌시고 ㄱㄱ

*/
// 벽이아니라면,
//      기존 처럼 (cx , cy , used) -> (nx , ny , used)
// 벽이라면,
//      used > k 일 때 continue;
//      used <= k 일 때  (cx , cy , used) -> (nx , ny , used+1)
