// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {      //  동  서  남  북
    static int n , m;
    static int[] dx = new int[]{0, 0, 1, -1};  // 동(0), 서(1), 남(2), 북(3) : 행 변화
    static int[] dy = new int[]{1, -1, 0, 0};  // 열 변화

    static final int INF = Integer.MAX_VALUE;
    static boolean[][] grid;
    static class Node {
        int x, y;
        int d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        grid = new boolean[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int sd = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int ex = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());
        int ed = Integer.parseInt(st.nextToken()) - 1;

        Node start = new Node(sx, sy, sd);
        Node end = new Node(ex, ey, ed);

        int answer = bfs(start, end);
        System.out.println(answer);
    }

    static int bfs(Node start, Node end) {
        int[][][]dist = new int[m + 1][n + 1][4];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                Arrays.fill(dist[i][j], -1);

        Queue<Node> que = new ArrayDeque<>();

        dist[start.x][start.y][start.d] = 0;
        que.add(start);

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int cd = cur.d;
            int curDist = dist[cur.x][cur.y][cd];
            if (cur.x == end.x && cur.y == end.y && cd == end.d) {
                return curDist;
            }

            // 회전
            int ld = turnLeft(cd);
            if (dist[cur.x][cur.y][ld] == -1) {
                dist[cur.x][cur.y][ld] = curDist + 1;
                que.add(new Node(cur.x, cur.y, ld));
            }

            int rd = turnRight(cd);
            if (dist[cur.x][cur.y][rd] == -1) {
                dist[cur.x][cur.y][rd] = curDist + 1;
                que.add(new Node(cur.x, cur.y, rd));
            }

            for (int k = 1; k <= 3; k++) {
                int nx = cur.x + k * dx[cd];
                int ny = cur.y + k * dy[cd];

                if (outOfRange(nx, ny)) break;
                if (grid[nx][ny]) break;
                if (dist[nx][ny][cd] == -1) {
                    dist[nx][ny][cd] = curDist + 1;
                    que.add(new Node(nx, ny, cd));
                }

            }
        }
        return dist[end.x][end.y][end.d];
    }

    static boolean outOfRange(int x, int y) {
        return x < 1 || x > m || y < 1 || y > n;
    }

    static int turnRight(int d) {
        if (d == 0) {
            return 2;
        } else if (d == 1) {
            return 3;
        } else if (d == 2) {
            return 1;
        } else if (d == 3) {
            return 0;
        }
        return -1;
    }

    static int turnLeft(int d) {
        if (d == 0) {
            return 3;
        }
        else if (d == 1) {
            return 2;
        }
        else if (d == 2) {
            return 0;
        }
        else if (d == 3) {
            return 1;
        }
        return -1;
    }

}

/*
    로봇의 출발 지점의 위치 (행과 열의 번호)와 바라보는 방향이 빈칸을 사이에 두고 주어진다.

    로봇의 도착 지점의 위치 (행과 열의 번호)와 바라보는 방향이 빈칸을 사이에 두고 주어진다.

    0 은 길
    1 은 벽

    명령 의 종류는 2가지 : 현재 방향으로 1~3 칸 이동
                     : 방향 90도 회전 (+ 2 , + 3) div
                     동 0, 서 1, 남 2, 북 3
                     동 0 -> 2,3
                     서 1 -> 2,3
                     남 2 -> 0,1
                     북 3 -> 0,1

                     동 0 -> 북 3
                     서 1 -> 남 2
                     남 2 -> 동 0
                     북 3 -> 서 1

*/
