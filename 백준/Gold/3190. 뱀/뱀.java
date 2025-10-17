
import java.io.*;
import java.util.*;

public class Main {
    static boolean [][] grid;
    static int n;                   //동 남 서 북
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};
    static Map<Integer, Character> timeTable;

    public static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            Pos o = (Pos)obj;
            return this.x == o.x && this.y == o.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        grid = new boolean[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            grid[r][c] = true;
        }

        timeTable = new HashMap<>();
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            timeTable.put(x, c);
        }
        int result = simulation(1, 1, 0);
        System.out.println(result);
    }

    private static int simulation(int sx, int sy, int d) {
        int time = 0;
        Deque<Pos> snakeForTail = new ArrayDeque<>();
        Set<Pos> snakeForBody = new HashSet<>();
        Pos start = new Pos(sx, sy);
        snakeForTail.add(start);
        snakeForBody.add(start);

        while (true) {
            time++;
            int nx = sx + dx[d]; int ny = sy + dy[d];
            Pos next = new Pos(nx, ny);
            if (outOfRange(nx,ny)) break;
            if (snakeForBody.contains(next)) break;

            snakeForTail.add(next);
            snakeForBody.add(next);

            if (grid[nx][ny]) grid[nx][ny] = false; // 사과가 있다면
            else { // 사과가 없다면
                Pos removed = snakeForTail.pollFirst();
                snakeForBody.remove(removed);
            }
            sx = nx; sy = ny;

            Character cmd = timeTable.get(time);
            if (cmd != null){
                if (cmd == 'D')
                    d = (d + 1) % dx.length;                  // 시계
                else if (cmd == 'L')
                    d = (d - 1 + dx.length) % dx.length; // 반시계
            }
        }
        return time;
    }
    private static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }
}
