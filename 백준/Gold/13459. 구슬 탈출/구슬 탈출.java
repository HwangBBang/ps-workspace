// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {
    static int n, m;
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};
    static char[][] grid;

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x; this.y = y;
        }
        public boolean isSamePoint(Point other) {
            return x == other.x && y == other.y;
        }
    }

    static class Node {
        Point blue;
        Point red;
        int depth;

        public Node(Point blue, Point red, int depth) {
            this.blue = blue;
            this.red = red;
            this.depth = depth;
        }

    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new char[n][m];
        Point blue = new Point(0, 0), red = new Point(0, 0);

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (line[j] == 'B') {
                    blue = new Point(i, j);
                    grid[i][j] = '.';
                } else if (line[j] == 'R') {
                    red = new Point(i, j);
                    grid[i][j] = '.';
                } else {
                    grid[i][j] = line[j];
                }
            }
        }

        System.out.println(simulation(blue, red));
    }

    private static int simulation(Point blue, Point red) {
        ArrayDeque<Node> que = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[n][m][n][m];

        Node node = new Node(blue, red, 0);
        visited[blue.x][blue.y][red.x][red.y] = true;
        que.add(node);

        while (!que.isEmpty()){
            Node cur = que.poll();
            if (cur.depth >= 10) continue;
            blue = cur.blue;
            red = cur.red;

            for (int dir = 0; dir < 4; dir++) {
                Point nextBlue = move(cur.blue, dir);
                Point nextRed = move(cur.red, dir);

                // 실패
                if (nextBlue == null) continue;
                // 성공
                if (nextRed == null) return 1;

                // 둘다 안 빠짐

                // 같은 칸에 있는 경우, 더많이 이동한 것을 방향 만큼 한칸 뒤로
                if (nextRed.isSamePoint(nextBlue)) {
                    int bDist = dist(blue, nextBlue);
                    int rDist = dist(red, nextRed);

                    if (rDist > bDist) {
                        nextRed = new Point(nextRed.x - dx[dir], nextRed.y - dy[dir]);
                    } else {
                        nextBlue = new Point(nextBlue.x - dx[dir], nextBlue.y - dy[dir]);
                    }
                }

                if (!visited[nextBlue.x][nextBlue.y][nextRed.x][nextRed.y]) {
                    visited[nextBlue.x][nextBlue.y][nextRed.x][nextRed.y] = true;
                    que.add(new Node(nextBlue, nextRed, cur.depth + 1));
                }
            }
        }
        return 0;
    }
    static int dist(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private static Point move(Point point, int dir) {
        int x = point.x;
        int y = point.y;

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (outOfRange(nx,ny)) break;
            if (grid[nx][ny] == '#') break;
            if (grid[nx][ny] == 'O') return null;

            x = nx ;
            y = ny;
        }
        return new Point(x, y);
    }

    static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}


/*
    가장 밖은 막혀있다.
    빨간 구슬을 구멍으로 빼내야한다. (파란구슬을 빼내면 안돼, 동시도 안돼)
    전체 구슬을 4가지 방향 중 하나로 민다.
    더이상 구슬이 움직이지 않을 때까지 지속한다.
     '.'은 빈 칸,
     '#'은 공이 이동할 수 없는 벽,
     'O'는 구멍의 위치
     'R'은 빨간 구슬의 위치
     'B'는 파란 구슬의 위치이다

    4 가지 방향 중 하나로 구슬을 이동시키는 함수
    move (grid , dir) => grid

    10 10 10 10 => 10000

    같은 칸에 위치하게 되는 경우
    더 많이 움직인 구슬을 한 칸 빠꾸
 */