// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};
    static int[][] grid;
    static int n;
    static class Node implements Comparable<Node>{
        int x, y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }

    }
    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int step = 1;

        while (true){
            n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            grid = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 입력 끝

            int result = dijkstra();

            sb.append(String.format("Problem %d: ", step)).append(result).append("\n");

            step++;
        }
        System.out.println(sb);

    }

    static int dijkstra() {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0][0] = grid[0][0];
        pq.add(new Node(0, 0, grid[0][0]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (outOfRange(nx,ny)) continue;
                if (dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[cur.x][cur.y] + grid[nx][ny];
                pq.add(new Node(nx, ny, dist[nx][ny]));

            }
        }

        return dist[n - 1][n - 1];
    }

    static boolean outOfRange(int nx, int ny) {
        return nx < 0 || nx >= n || ny < 0 || ny >= n;
    }

}

/*
*/