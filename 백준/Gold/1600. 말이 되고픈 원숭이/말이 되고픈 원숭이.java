// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] mDx = new int[]{0, 1, 0, -1};
    static int[] mDy = new int[]{1, 0, -1, 0};
    static int[] hDx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hDy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    static int w, h;
    static int[][] grid;

    static class Node {
        int x, y;
        int move;

        public Node(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }


    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        grid = new int[h + 1][w + 1];
        for (int i = 1; i <= h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= w; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = bfs(k);
        System.out.println(answer);
    }

    static int bfs(int k) {
        Queue<Node> que = new ArrayDeque<>();
        int[][][] dist = new int[h + 1][w + 1][k + 1];
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }

        dist[1][1][0] = 0;
        que.add(new Node(1, 1, 0));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.x == h && cur.y == w) return dist[cur.x][cur.y][cur.move];

            for (int i = 0; i < mDx.length; i++) {
                int nx = cur.x + mDx[i];
                int ny = cur.y + mDy[i];
                if (outOfRange(nx, ny)) continue;
                if (grid[nx][ny] == 1) continue;
                if (dist[nx][ny][cur.move] != -1) continue;
                
                dist[nx][ny][cur.move] = dist[cur.x][cur.y][cur.move] + 1;
                que.add(new Node(nx, ny, cur.move));
            }

            if (cur.move < k) {
                for (int i = 0; i < hDx.length; i++) {
                    int nx = cur.x + hDx[i];
                    int ny = cur.y + hDy[i];
                    if (outOfRange(nx, ny)) continue;
                    if (grid[nx][ny] == 1) continue;
                    if (dist[nx][ny][cur.move+1] != -1) continue;
                    
                    dist[nx][ny][cur.move + 1] = dist[cur.x][cur.y][cur.move] + 1;
                    que.add(new Node(nx, ny, cur.move + 1));
                }
            }
        }
        return -1;
    }

    private static boolean outOfRange(int x, int y) {
        return x < 1 || h < x || y < 1 || w < y;
    }
}

