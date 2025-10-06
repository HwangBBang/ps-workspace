import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] grid;
    static boolean[][] isOut;

    static class Pos {
        int x, y;
        public Pos(int x, int y) {this.x = x; this.y = y;}
    }

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static int n, m;

    public static void main(String[] args) throws IOException{
        //System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new boolean[n][m];
        isOut = new boolean[n][m];

        String IN = "1";
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = st.nextToken().equals(IN);
            }
        }

         // 격자 외부 내부판단
        Queue<Pos> willRemove = new ArrayDeque<>(); //치즈 제거
        int answer = -1;

        while (!isAllOut()){
            // print();
            bfs(new Pos(0, 0));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (isOut[i][j]) continue;
                    if (!isOverTwo(i, j)) continue;
                    willRemove.add(new Pos(i, j));
                }
            }

            while (!willRemove.isEmpty()) {
                Pos target = willRemove.poll();
                grid[target.x][target.y] = false;
            }

            answer++;
        }
        System.out.println(answer);
    }

    static void bfs(Pos start) {
        boolean[][] v = new boolean[n][m];
        Queue<Pos> queue = new ArrayDeque<>();
        isOut[start.x][start.y] = true;
        v[start.x][start.y] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            for (int i = 0; i < dy.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (outOfRange(nx,ny)) continue;
                if (v[nx][ny]) continue;
                if (grid[nx][ny]) continue;

                v[nx][ny] = true;
                isOut[nx][ny] = true;
                queue.add(new Pos(nx, ny));
            }
        }

    }

    static boolean outOfRange(int x, int y) {
        return 0 > x || n <= x || 0 > y || m <= y;
    }

    static boolean isAllOut() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!isOut[i][j]) return false;
            }
        }
        return true;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]) sb = sb.append(1);
                else sb = sb.append(0);
                sb = sb.append(" ");
            }
            sb = sb.append("\n");
        }
        System.out.println(sb);
    }


    static boolean isOverTwo(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isOut[nx][ny]) cnt++;
        }
        return cnt >= 2;
    }

}
/*
    N * M <= 100_000

1. 격자의 외부, 내부 판단
2. 외부 인칸이 2칸 이상이라면, 삭제
3. 외부인칸 판단 방법은 0,0에서 BFS 돌리자. ( 가장자리에는 치즈가 놓이지 않는 것으로 가정하기에 )
*/
