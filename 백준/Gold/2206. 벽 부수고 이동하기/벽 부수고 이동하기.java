
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
    static int n, m;
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

        isWall = new boolean[n+1][m+1];
        dist = new int[n+1][m+1][2]; // 미방문 -1

        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= m; j++) {
                Arrays.fill(dist[i][j], NOT);
            }
        }



        for (int i = 1; i <= n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                isWall[i][j] = (chars[j-1] == '1');
            }
        }

        bfs(new Pos(1,1,0));
        int answer = Math.max(dist[n][m][0], dist[n][m][1]);
        System.out.println(answer);
    }

    static void bfs(Pos start){

        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(start);
        dist[start.x][start.y][start.s] = 1;

        while (!queue.isEmpty()){
            Pos cur = queue.poll();
            int cx = cur.x, cy = cur.y, cs = cur.s;

            if (cx == n && cy == m) return;

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int ns = cs;

                if (outOfRange(nx,ny)) continue;// 범위

                if (!isWall[nx][ny]) { // 벽이 아니라면
                    if (dist[nx][ny][ns] == NOT){ // 미방문이라면
                        dist[nx][ny][ns] = dist[cx][cy][cs] +1;
                        queue.add(new Pos(nx,ny,ns));
                    }
                } else { // 벽이 라면
                    if (cs == 1) continue; // 벽이 뿌셨음

                    ns = 1;
                    if (dist[nx][ny][ns] == NOT){
                        dist[nx][ny][ns] = dist[cx][cy][cs] +1;
                        queue.add(new Pos(nx,ny,ns));
                    }

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
// 벽하나 뿌시는것을 어떻게 구현하지?
//  -> 상태관한 것 (열쇠보유, 벽 부시기, 낮/밤, 남은 이동수 같은 상태에 따라 선택지가 달라지는 문제는
//  -> 좌표 2개 만으로 해결 할 수 없어,
//  -> 따라서 상태에 대한 필드 까지 포함해야해, 상태의 경우 작고 유한한 범위여야해
// 상태가 포함된다면, 정점에 대한 메모리는 1_000 * 1_000 * 2 (상태 수)
// 전이 규칙.

// 벽이아니라면,
//      기존 처럼 (cx , cy , used) -> (nx , ny , used)
// 벽이라면,
//      used == 1 일 때 continue;
//      used == 0 일 때  (cx , cy , used) -> (nx , ny , used+1)
