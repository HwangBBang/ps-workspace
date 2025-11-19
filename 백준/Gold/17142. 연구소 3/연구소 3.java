// package baekjoon.gold;

import java.io.*;
import java.util.*;


public class Main {
    static int n, m, answer;
    static int[][] grid;
    static List<int[]> candidate;

    static final int INF = Integer.MAX_VALUE;
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n + 1][n + 1];
        candidate = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 2) candidate.add(new int[]{i, j});
            }
        }
//        바이러스 갯수 (l) 중 m 개에서 시작하여 걸리는 최단 시간
//        l C m -> 백트랙킹
        answer = INF;
        List<int[]>selected  = new ArrayList<>();
        choice(selected,0);
        System.out.println(answer == INF ? -1 : answer);
    }

    static void choice(List<int[]> selected ,int step) {
        if (selected.size() == m) {
            answer = Math.min(answer, bfs(selected));
            return;
        }
        for (int i = step; i < candidate.size(); i++) {
            selected.add(candidate.get(i));
            choice(selected, i + 1);
            selected.remove(selected.size() - 1);
        }

    }

    static int bfs(List<int[]> selected) {
        int[][]dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) Arrays.fill(dist[i], -1);

        for (int i = 0; i < selected.size(); i++) {
            int[] point = selected.get(i);
            dist[point[0]][point[1]] = 0;
        }
        Queue<int[]> que = new ArrayDeque<>(selected);
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (outOfRange(nx,ny)) continue;
                if (dist[nx][ny] != -1) continue;
                if (grid[nx][ny] == 1) continue;

                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                que.add(new int[]{nx, ny});
            }
        }
        int result = -INF;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i][j] == 0){
                    if (dist[i][j] == -1) return INF;
                    result = Math.max(result, dist[i][j]);
                }
            }
        }
        return result == -INF ? 0 : result;
    }

    static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }


}


/*
    0은 빈 칸,
    1은 벽,
    2는 바이러스의 위치이다.
 */