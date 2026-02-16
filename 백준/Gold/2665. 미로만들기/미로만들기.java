// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static final int INF = Integer.MAX_VALUE;
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};

    static int n;
    static char[][] grid;

    static class Node implements Comparable<Node> {
        int x, y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node other) {
            if (this.cnt != other.cnt) {
                return Integer.compare(this.cnt, other.cnt);
            } else if (this.x != other.x) {
                return Integer.compare(other.x, this.x);
            } else {
                return Integer.compare(other.y, this.y);
            }
        }
    }
    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        grid = new char[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 1; j <= n; j++) {
                grid[i][j] = line[j - 1];
            }
        }

        int result = simulation();
        int answer = result == INF ? 0 : result;
        System.out.println(answer);
    }

    static int simulation() {
        int[][] cntGrid = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(cntGrid[i], INF);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();

        cntGrid[1][1] = 0;
        pq.add(new Node(1, 1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cntGrid[cur.x][cur.y] != cur.cnt) continue;
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (outOfRange(nx,ny)) continue;
                if (cntGrid[nx][ny] != INF) continue;
                if (grid[nx][ny] == '1') {
                    cntGrid[nx][ny] = cur.cnt;
                    pq.add(new Node(nx, ny, cntGrid[nx][ny]));
                } else { // 다음 방이 검은방
                    if (cntGrid[nx][ny] >= cur.cnt + 1) {
                        cntGrid[nx][ny] = cur.cnt + 1;
                        pq.add(new Node(nx, ny, cntGrid[nx][ny]));
                    }
                }
            }
        }
        return cntGrid[n][n];

    }

    static boolean outOfRange(int nx, int ny) {
        return nx < 1 || nx > n || ny < 1 || ny > n;
    }
}

/*
    0. 검은방 / 1. 흰방

*/