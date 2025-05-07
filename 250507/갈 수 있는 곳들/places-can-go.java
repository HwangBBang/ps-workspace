import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Queue<Position> queue = new LinkedList<>();
    static Position[] starts;
    static List<Position> answer = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] grid;
    static int n, k;

    static class Position {
        int x;
        int y;

        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        visited = new boolean[n][n];
        starts = new Position[k];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int ii = 0; ii < n; ii++) {
                grid[i][ii] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            starts[i] = new Position(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        }

        for (Position pos : starts) {
            if(visited[pos.x][pos.y]) continue;
            bfs(pos.x, pos.y);
        }

        System.out.println(answer.size());

    }

    static void bfs(int x, int y) {
        queue.add(new Position(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()){
            Position poped = queue.poll();
            answer.add(poped);

            int curX = poped.x;
            int curY = poped.y;


            for (int i = 0; i < dx.length; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (isNotRange(nx, ny)) continue;
                if (grid[nx][ny] == 1 || visited[nx][ny]) continue;

                queue.add(new Position(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    static boolean isNotRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }

//    Queue 인터페이스의 구현체 : LinkedList , ArrayDeque
//    BFS 에서는 주로 LikedList 가 사용된다.
//    push : add()
//    left pop : poll()
//    queue 가 비어있으면 null 을 반환한다.

}
