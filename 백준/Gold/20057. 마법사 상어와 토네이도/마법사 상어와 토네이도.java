// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    static int[][] grid;
    static int n;

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
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Node> order = getOrder();
        int answer = simulation(order);
        System.out.println(answer);
    }

    static int simulation(List<Node> order) {
        int result = 0;
        Queue<Node> que = new ArrayDeque<>(order);

        while (!que.isEmpty()) {
            Node cur = que.poll();
            result += spread(cur.x, cur.y, cur.d);

        }
        return result;
    }

    static int spread(int xr, int xc, int d) {
        int result = 0;

        int yr = xr + dx[d];
        int yc = xc + dy[d];
        if (outOfRange(yr, yc)) return 0;

        int sand = grid[yr][yc];
        if (sand == 0) return 0;

        grid[yr][yc] = 0;

        int sum = 0;

        // alpha 위치(한 칸 앞)
        int ar = yr + dx[d];
        int ac = yc + dy[d];

        // 5% 
        int v5 = sand * 5 / 100; sum += v5;
        int r5 = ar + dx[d], c5 = ac + dy[d];
        if (outOfRange(r5, c5)) result += v5; else grid[r5][c5] += v5;

        // 10%
        int v10 = sand * 10 / 100; sum += v10 * 2;
        int r10 = ar + dx[(d + 1) % 4], c10 = ac + dy[(d + 1) % 4];
        if (outOfRange(r10, c10)) result += v10; else grid[r10][c10] += v10;
        r10 = ar + dx[(d + 3) % 4]; c10 = ac + dy[(d + 3) % 4];
        if (outOfRange(r10, c10)) result += v10; else grid[r10][c10] += v10;

        // 7% 
        int v7 = sand * 7 / 100; sum += v7 * 2;
        int r7 = yr + dx[(d + 1) % 4], c7 = yc + dy[(d + 1) % 4];
        if (outOfRange(r7, c7)) result += v7; else grid[r7][c7] += v7;
        r7 = yr + dx[(d + 3) % 4]; c7 = yc + dy[(d + 3) % 4];
        if (outOfRange(r7, c7)) result += v7; else grid[r7][c7] += v7;

        // 2% 
        int v2 = sand * 2 / 100; sum += v2 * 2;
        
        int r2 = (yr + dx[(d + 1) % 4]) + dx[(d + 1) % 4];
        int c2 = (yc + dy[(d + 1) % 4]) + dy[(d + 1) % 4];
        if (outOfRange(r2, c2)) result += v2; else grid[r2][c2] += v2;
        
        r2 = (yr + dx[(d + 3) % 4]) + dx[(d + 3) % 4];
        c2 = (yc + dy[(d + 3) % 4]) + dy[(d + 3) % 4];
        if (outOfRange(r2, c2)) result += v2; else grid[r2][c2] += v2;
        
        int v1 = sand * 1 / 100; sum += v1 * 2;
        
        int r1 = xr + dx[(d + 1) % 4], c1 = xc + dy[(d + 1) % 4];
        if (outOfRange(r1, c1)) result += v1; else grid[r1][c1] += v1;
        r1 = xr + dx[(d + 3) % 4]; c1 = xc + dy[(d + 3) % 4];
        if (outOfRange(r1, c1)) result += v1; else grid[r1][c1] += v1;

        //  남은 모래
        int alpha = sand - sum;
        if (outOfRange(ar, ac)) result += alpha;
        else grid[ar][ac] += alpha;

        return result;

    }


    static List<Node> getOrder() {
        List<Node> order = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> que = new ArrayDeque<>();

        int d = 0;
        visited[0][0] = true;
        que.add(new int[]{0, 0});
        order.add(new Node(0, 0, d));

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (cur[0] == n/2 && cur[1] == n/2) break;
            int nx = cur[0] + dx[d];
            int ny = cur[1] + dy[d];

            if (outOfRange(nx,ny) || visited[nx][ny]) {
                d = (d + 1) % 4;
                que.add(new int[]{cur[0], cur[1]});
                continue;
            }

            visited[nx][ny] = true;
            que.add(new int[]{nx, ny});
            order.add(new Node(nx, ny, d));
        }

        Collections.reverse(order);
        for (Node node : order) node.d = (node.d + 2) % 4;
        return order;
    }

    static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }
}

/*

 */