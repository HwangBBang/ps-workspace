//package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static final int LEN = 5;
    static final int[] dx = new int[]{1, 0, -1, 0, 0, 0};
    static final int[] dy = new int[]{0, 1, 0, -1, 0, 0};
    static final int[] dz = new int[]{0, 0, 0, 0, 1, -1};
    static final int INF = Integer.MAX_VALUE;

    static List<Grid> result = new ArrayList<>();
    static int answer;

    static class Grid {
        int[][] value;

        public Grid(int[][] value) {
            this.value = value;
        }

        public void rotate() {
            int[][] next = new int[LEN][LEN];
            for (int i = 0; i < LEN; i++) {
                for (int j = 0; j < LEN; j++) {
                    next[j][LEN - 1 - i] = value[i][j]; // 시계 방향 90도
                }
            }
            value = next;

        }
    }

    static class Pos {
        int x, y, z;

        public Pos(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] temp;
        Grid[] grids = new Grid[5];

        for (int k = 0; k < LEN; k++) {
            temp = new int[LEN][LEN];
            for (int i = 0; i < LEN; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < LEN; j++) {
                    temp[i][j] = Integer.parseInt(st.nextToken()); // 최적화 boolean
                }
            }
            grids[k] = new Grid(temp);
        }
        answer = INF;
        choice(new boolean[LEN], grids);

        answer = answer == INF ? -1 : answer;
        System.out.println(answer);
    }
    static void rotateGrid(int idx, List<Grid> result) {
        if (idx == 5) {
            if (result.get(0).value[0][0] == 0) return;
            if (result.get(4).value[4][4] == 0) return;
            answer = Math.min(answer, bfs(result));
            return;
        }
        Grid curGrid = result.get(idx);

        for (int i = 0; i < 4; i++) {
            curGrid.rotate();
            rotateGrid(idx + 1, result);
        }

    }

    static void choice(boolean[] visited, Grid[] grids) {
        if (result.size() == LEN) {
            rotateGrid(0, result);
            return;
        }

        for (int i = 0; i < LEN; i++) {
            if(visited[i]) continue;

            result.add(grids[i]);
            visited[i] = true;

            choice(visited, grids);

            result.remove(result.size() - 1);
            visited[i] = false;
        }
    }

    static int bfs(List<Grid> grids) {
        Queue<Pos> queue = new ArrayDeque<>();
        int[][][] dist = new int[LEN][LEN][LEN];

        for (int i = 0; i < LEN; i++)
            for (int j = 0; j < LEN; j++) Arrays.fill(dist[i][j], INF);

        dist[0][0][0] = 0;
        queue.add(new Pos(0,0,0));

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                int nextZ = cur.z + dz[i];

                if (outOfRange(nextX,nextY,nextZ)) continue;
                if (grids.get(nextZ).value[nextX][nextY] == 0) continue;
                if (dist[nextX][nextY][nextZ] != INF) continue;

                dist[nextX][nextY][nextZ] = dist[cur.x][cur.y][cur.z] + 1;
                queue.add(new Pos(nextX, nextY, nextZ));
            }
        }
        return dist[LEN - 1][LEN - 1][LEN - 1];
    }

    static boolean outOfRange(int x, int y, int z) {
        return 0 > x || LEN <= x || 0 > y || LEN <= y || 0 > z || LEN <= z ;
    }


/*
    00 01 02 03 04
    10 11 12 13 14
    20 21 22 23 24
    30 31 32 33 34
    40 41 42 43 44

    00 10 20 30 40
    01 11 21 31 41
    02 12 22 32 42


   판들의 무작위 선택은 5! * 4^5
   각판에서 돌리기
        원본 시계1 시계2  시계3 원본


   이제 3차원이 만들어졌다고 치자.
   bfs로 최단 거리 뽑기.

    12_000_000
*/
}
